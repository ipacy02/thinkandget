package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static java.util.regex.Pattern.compile;
import constants.locators.ShopLocators;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ShopPage extends BasePage {

    private final Locator sortSelectDropdown;
    private final Locator searchToggleButton;

    public ShopPage(Page page) {
        super(page);
        this.sortSelectDropdown = page.locator(ShopLocators.SORT_SELECT_DROPDOWN);
        this.searchToggleButton = page.locator(ShopLocators.SEARCH_TOGGLE_BUTTON).first();
    }

    public void selectCategory(String categoryName) {
        page.locator(ShopLocators.SIDEBAR_CONTAINER)
                .first()
                .locator(ShopLocators.GENERIC_BUTTON)
                .filter(new Locator.FilterOptions().setHasText(categoryName))
                .click();
    }

    public ShopPage selectSortOption(String targetValue) {
        sortSelectDropdown.waitFor();
        sortSelectDropdown.selectOption(targetValue);
        return this;
    }

    public List<Double> getProductPrices() {
        Locator priceElements = page.locator(ShopLocators.PRODUCT_CARD_ANCHOR).locator(".text-lg.font-bold");

        List<Double> prices = new ArrayList<>();
        int count = priceElements.count();

        for (int i = 0; i < count; i++) {
            String rawText = priceElements.nth(i).innerText();
            String cleanText = rawText.replaceAll("[^0-9.]", "");
            if (!cleanText.isEmpty()) {
                prices.add(Double.parseDouble(cleanText));
            }
        }
        return prices;
    }

    public ShopPage selectPriceRangePreset(String rangeText) {
        Locator rangeButton = page.locator(ShopLocators.PRICE_SECTION_CONTAINER)
                .locator(ShopLocators.GENERIC_BUTTON)
                .filter(new Locator.FilterOptions().setHasText(rangeText))
                .first();

        rangeButton.waitFor();
        rangeButton.click();
        return this;
    }

    public ShopPage selectSize(String sizeText) {
        Locator sizeButton = page.locator(ShopLocators.BASE_SIDEBAR_GROUP)
                .filter(new Locator.FilterOptions().setHasText(ShopLocators.SIZE_SECTION_TEXT))
                .locator(ShopLocators.GENERIC_BUTTON)
                .filter(new Locator.FilterOptions().setHasText(compile("^" + sizeText + "$")))
                .first();

        sizeButton.waitFor();
        sizeButton.click();
        return this;
    }

    public ShopPage selectColor(String colorName) {
        Locator colorSection = page.locator(ShopLocators.BASE_SIDEBAR_GROUP)
                .filter(new Locator.FilterOptions().setHasText(ShopLocators.COLOR_SECTION_TEXT));

        Locator colorButton = colorSection.locator(ShopLocators.GENERIC_BUTTON)
                .filter(new Locator.FilterOptions().setHasText(
                        compile("^" + colorName + "$", Pattern.CASE_INSENSITIVE)
                ))
                .or(colorSection.locator(String.format(ShopLocators.COLOR_TITLE_TEMPLATE, colorName)))
                .or(colorSection.locator(String.format(ShopLocators.COLOR_VALUE_TEMPLATE, colorName)))
                .or(colorSection.locator(String.format(ShopLocators.COLOR_CLASS_TEMPLATE, colorName.toLowerCase())))
                .first();

        colorButton.waitFor();
        colorButton.click();
        return this;
    }

    public ShopPage searchProduct(String productName) {
        searchToggleButton.waitFor();
        searchToggleButton.click();

        Locator contextualSearchInput = page.locator(ShopLocators.SEARCH_INPUT_FIELD).first();

        contextualSearchInput.waitFor();
        contextualSearchInput.fill("");
        contextualSearchInput.pressSequentially(productName);
        contextualSearchInput.press("Enter");
        return this;
    }

    public Locator getSearchResultsHeader() {
        return page.locator(ShopLocators.SEARCH_RESULTS_HEADER)
                .filter(new Locator.FilterOptions().setHasText(ShopLocators.SEARCH_RESULTS_TEXT))
                .first();
    }

    public Locator getProductCardByName(String productName) {
        return page.locator(ShopLocators.PRODUCT_CARD_ANCHOR)
                .filter(new Locator.FilterOptions().setHasText(productName))
                .first();
    }
}
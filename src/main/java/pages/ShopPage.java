package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static java.util.regex.Pattern.compile;
import constants.ShopLocators; // Imported centralized shop selectors

public class ShopPage extends BasePage {

    private final Locator sortSelectDropdown;
    private final Locator sidebarContainer;
    private final Locator searchToggleButton;

    public ShopPage(Page page) {
        super(page);
        this.sortSelectDropdown = page.locator(ShopLocators.SORT_SELECT_DROPDOWN);
        this.sidebarContainer = page.locator(ShopLocators.SIDEBAR_CONTAINER);
        this.searchToggleButton = page.locator(ShopLocators.SEARCH_TOGGLE_BUTTON).first();
    }

    // --- CATEGORY FILTERING ---
    public ShopPage selectCategory(String categoryName) {
        Locator categoryButton = sidebarContainer.locator(ShopLocators.GENERIC_BUTTON)
                .filter(new Locator.FilterOptions().setHasText(categoryName))
                .first();

        categoryButton.waitFor();
        categoryButton.click();
        return this;
    }

    // --- DROPDOWN SORTING ---
    public ShopPage selectSortOption(String targetValue) {
        sortSelectDropdown.waitFor();
        sortSelectDropdown.selectOption(targetValue);
        return this;
    }

    // --- PRESET PRICE CAPSULE FILTERING ---
    public ShopPage selectPriceRangePreset(String rangeText) {
        // Target the correct 'flex-wrap' container node directly
        Locator rangeButton = page.locator(ShopLocators.PRICE_SECTION_CONTAINER)
                .locator(ShopLocators.GENERIC_BUTTON)
                .filter(new Locator.FilterOptions().setHasText(rangeText))
                .first();

        rangeButton.waitFor();
        rangeButton.click();
        return this;
    }

    //--- SIZE SORTING ---
    public ShopPage selectSize(String sizeText) {
        Locator sizeButton = page.locator(ShopLocators.SIZE_SECTION)
                .filter(new Locator.FilterOptions().setHasText(ShopLocators.SIZE_SECTION_TEXT))
                .locator(ShopLocators.GENERIC_BUTTON)
                .filter(new Locator.FilterOptions().setHasText(compile("^" + sizeText + "$")))
                .first();

        sizeButton.waitFor();
        sizeButton.click();
        return this;
    }

    //--- COLOR SORTING ---
    public ShopPage selectColor(String colorName) {
        Locator colorSection = page.locator(ShopLocators.COLOR_SECTION)
                .filter(new Locator.FilterOptions().setHasText(ShopLocators.COLOR_SECTION_TEXT));

        Locator colorButton = colorSection.locator(ShopLocators.GENERIC_BUTTON)
                .filter(new Locator.FilterOptions().setHasText(
                        compile("^" + colorName + "$", java.util.regex.Pattern.CASE_INSENSITIVE)
                ))
                .or(colorSection.locator("button[title='" + colorName + "']"))
                .or(colorSection.locator("button[value='" + colorName + "']"))
                .or(colorSection.locator("button[class*='bg-" + colorName.toLowerCase() + "']"))
                .first();

        colorButton.waitFor();
        colorButton.click();
        return this;
    }

    // --- SEARCH WORKFLOW METHOD ---

    public ShopPage searchProduct(String productName) {
        // 1. Click the header magnifying glass to open up the search modal overlay
        searchToggleButton.waitFor();
        searchToggleButton.click();

        // 2. Locate the input field dynamically inside the method once it pops onto the DOM
        Locator contextualSearchInput = page.locator(ShopLocators.SEARCH_INPUT_FIELD).first();

        // 3. Complete the interactive step sequence safely
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
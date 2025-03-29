package webshop.test.uiclient;

import api.webshop.pages.filterproductsbyprice.MainPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class FilterProduct {
    private static final String WEBSITE_URL = "https://demowebshop.tricentis.com/digital-downloads?orderby=10";

    @Step("Фильтрация товаров по цене")
    public void filterProductsByPrice() {
        Selenide.open(WEBSITE_URL, MainPage.class)
                .clickOnTheFilter()
                .selectToFilter()
                .productListUpdate();

        ElementsCollection priceElements = $$(".actual-price");
        NumberFormat format = NumberFormat.getInstance(Locale.FRENCH);

        List<Double> prices = priceElements.texts().stream()
                .map(price -> price.replace("From ", "").trim())
                .map(price -> {
                    try {
                        return format.parse(price).doubleValue();
                    } catch (ParseException e) {
                        throw new RuntimeException("Не удалось распарсить цену: " + price, e);
                    }
                })
                .collect(Collectors.toList());

        for (int i = 0; i < prices.size() - 1; i++) {
            double current = prices.get(i);
            double next = prices.get(i + 1);

            if (current > next) {
                String errorMsg = String.format(
                        "Нарушена сортировка: позиция %d (%.2f) > позиция %d (%.2f)\nВсе цены: %s",
                        i, current, i + 1, next, prices
                );
                throw new AssertionError(errorMsg);
            }
        }
    }
}

package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P11_OrderDetailsPage extends PageBase{
    public P11_OrderDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a.button-2.pdf-invoice-button")
    private WebElement pdfInvoiceLink;

    @FindBy(css = "a.button-2.print-order-button")
    private WebElement printInvoiceLnk;

    public void PrintOrderDetails() {
        clickButton(printInvoiceLnk);
    }

    public void DownloadPDFInvoice() throws InterruptedException {
        clickButton(pdfInvoiceLink);
        Thread.sleep(2000);
    }
}

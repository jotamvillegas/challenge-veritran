package com.project.pom.Helpers;

public class Parameters {

    public static ExcelUtil ex = new ExcelUtil();

    public static String urlHome, productSearch, priceInResults, priceInDetails, priceInShoppingCart, value,
            cartCounter, expectedResultAddToCart, expectedResultEmptyCart;
    public static int pageNumber, articleNumber;

    public static void loadParametersTest01 () throws Exception {
        /******************** URL DATA *******************/
        ex.setExcelFileSheet("URLs");
        urlHome = ex.getCellData(1, 0);

        /******************* SEARCH DATA ************/
        ex.setExcelFileSheet("Product Search");
        productSearch = ex.getCellData(1, 0);
        pageNumber = Integer.valueOf(ex.getCellData(1, 1));
        articleNumber = Integer.valueOf(ex.getCellData(1, 2));
        priceInResults = ex.getCellData(1,3);
        priceInDetails = ex.getCellData(1,4);
        priceInShoppingCart = ex.getCellData(1,5);
        cartCounter = ex.getCellData(1,6);
        expectedResultAddToCart = ex.getCellData(1,7);
        expectedResultEmptyCart = ex.getCellData(1,8);
    }

    public static String getValue (String sheetName, int row, int columm) throws Exception {
        ex.setExcelFileSheet(sheetName);
        value = ex.getCellData(row,columm);
        return value;
    }

    public static void setValue (String value, String sheetName, int row, int columm) throws Exception {
        ex.changeCellData(value, sheetName, row, columm);
    }


}

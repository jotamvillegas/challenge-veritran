package com.project.pom.Helpers;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtil {

    public final String currentDir = System.getProperty("user.dir");
    public String testDataExcelPath = "DataConfig/";
    private XSSFWorkbook excelWBook;
    private XSSFSheet excelWSheet;
    private XSSFCell cell;
    private XSSFRow row;
    public int rowNumber;
    public int columnNumber;

    /**
     * esta funcion primero verifica que sistema operativo se esta utilizando
     * para luego acceder a la ruta donde se encuentra nuestro excel y se
     * posiciona en la hoja que le entregamos
     *
     * @param nombreHoja texto que corresponde al nombre de la hoja en la cual nos
     * posicionaremos
     *
     */
    public void setExcelFileSheet(String nombreHoja) throws Exception {
        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
            testDataExcelPath = currentDir.replace("\\target","") + "//DataConfig//";
        } else if (Platform.getCurrent().toString().contains("WIN")) {
            testDataExcelPath = currentDir.replace("\\target","") + "//DataConfig//";
        } else if (Platform.getCurrent().toString().contains("LINUX")) {
            testDataExcelPath = currentDir.replace("\\target","") + "//DataConfig//";
        }
        try {
            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + "TestData.xlsx");
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(nombreHoja);
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Este metodo retorna datos de prueba que corresponden a la celda de Excel
     * que esta posicionada en el numero de fila y columna que le entregamos
     *
     * @param numFila numero de fila en la que esta posicionada la celda
     * @param numCol numero de columna en la que esta posicionada la celda
     *
     */
    public String getCellData(int numFila, int numCol) throws Exception {
        try {
            cell = excelWSheet.getRow(numFila).getCell(numCol);
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
            throw (e);
        }
    }

    /**
     * Este metodo retorna todos los datos del numero de fila entregado
     *
     * @param numFila numero de fila de donde se tomaran los datos
     */
    public XSSFRow getRowData (int numFila) throws Exception {
        try {
            row = excelWSheet.getRow(numFila);
            return row;
        } catch (Exception e) {
            throw (e);
        }
    }

    /**
     * Este metodo cambia los datos que se encuentran en la celda que esta
     * posicionada en el numero de fila y columna que le entregamos
     *
     * @param valor corresponde a los datos que le daremos a la celda
     * @param nombreHoja texto que corresponde al nombre de la hoja en la cual nos
     * posicionaremos
     * @param numFila numero de fila en la que esta posicionada la celda
     * @param numCol numero de columna en la que esta posicionada la celda
     *
     */
    public void changeCellData (String valor, String nombreHoja, int numFila,
                               int numCol) throws Exception {
        try {
            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + "TestData.xlsx");
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(nombreHoja);
            row = excelWSheet.getRow(numFila);
            cell = row.getCell(numCol);
            if (cell == null) {
                cell = row.createCell(numCol);
                cell.setCellValue(valor);
            } else {
                cell.setCellValue(valor);
            }
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + "TestData.xlsx");
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        Parameters.loadParametersTest01();
    }

}

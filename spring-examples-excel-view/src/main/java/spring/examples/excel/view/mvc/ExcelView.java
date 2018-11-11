package spring.examples.excel.view.mvc;

import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import spring.examples.excel.view.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.net.URLEncoder.encode;

public class ExcelView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        final String filename = "下载.xlsx";

        response.setHeader("Content-Disposition", "attachment; filename=" + encode(filename, "UTF-8"));

        Sheet sheet = workbook.createSheet("人员花名册");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("姓名");
        header.createCell(2).setCellValue("性别");
        header.createCell(3).setCellValue("生日");

        final List<User> list = Arrays.asList(
                new User("1", "Jerry", "M", new Date()),
                new User("2", "Jerry", "M", new Date())
        );

        int row = 1;

        for (User u : list) {
            Row it = sheet.createRow(row);

            Cell c0 = it.createCell(0);
            c0.setCellType(Cell.CELL_TYPE_STRING);
            c0.setCellValue(u.getId());

            Cell c1 = it.createCell(1);
            c1.setCellType(Cell.CELL_TYPE_STRING);
            c1.setCellValue(u.getName());

            Cell c2 = it.createCell(2);
            c2.setCellType(Cell.CELL_TYPE_STRING);
            c2.setCellValue(u.getGender());

            Cell c3 = it.createCell(3);
            CellStyle cellStyle1 = workbook.createCellStyle();
            cellStyle1.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("yyyy-MM-dd"));
            c3.setCellStyle(cellStyle1);
            c3.setCellValue(u.getDob());

            row++;
        }
    }

}

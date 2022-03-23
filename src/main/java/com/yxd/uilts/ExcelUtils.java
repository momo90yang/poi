package com.yxd.uilts;


import com.yxd.dto.People;
import com.yxd.dto.QuestionContentDto;
import com.yxd.dto.QuestionDto;
import com.yxd.dto.QuestionItemDto;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
public class ExcelUtils {
    /**
     * 导入excel
     * @param path
     * @return
     * @throws IOException
     */
    public List<QuestionDto> importExcel(String path) throws IOException {
        //导入的题目
        List<QuestionDto> questions = new ArrayList<>();
        List<QuestionItemDto> items = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(new FileInputStream(path));
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        QuestionContentDto content = new QuestionContentDto();
        for (int i = 0; i <=rows; i++) {
            QuestionDto question = new QuestionDto();
            //读取左上端单元格
            Row row = sheet.getRow(i);
            int j=i+1;
            //判断是题干还是选项
            if (row != null && (int) row.getCell((short) 0).getNumericCellValue() == 0) {
                //题干内容
                content.setTitle(row.getCell((short) 1).getStringCellValue());
                //考题类型
                content.setType((int) row.getCell(2).getNumericCellValue());
                //题目解析
                content.setAnalysis(row.getCell((short) 3).getStringCellValue());
                //题目分值
                content.setScore((int) row.getCell(4).getNumericCellValue());
                //难度分级
                content.setHardGrade((int) row.getCell(5).getNumericCellValue());
                //question.setContent(new QuestionContentDto(content.getTitle(),content.getType(),content.getAnalysis(),content.getScore(),content.getHardGrade()));
                if(j>rows){
                    question.setContent(new QuestionContentDto(content.getTitle(),content.getType(),content.getAnalysis(),content.getScore(),content.getHardGrade()));
                    questions.add(question);
                    break;
                }
                Cell cell = sheet.getRow(j).getCell(0);
                if ((int) cell.getNumericCellValue() == 0){
                    question.setContent(new QuestionContentDto(content.getTitle(),content.getType(),content.getAnalysis(),content.getScore(),content.getHardGrade()));
                    questions.add(question);
                }
                continue;
            }
            //题目选项
            if (row != null && ((int) row.getCell((short) 0).getNumericCellValue() == 1)) {
                QuestionItemDto item = new QuestionItemDto();
                //选项内容
                item.setContent(row.getCell((short) 1).getStringCellValue());
                //是否是正确答案
                item.setIsAnswer((int) row.getCell((short) 2).getNumericCellValue());
                items.add(item);
                //防止抛空指针异常
                if(j>rows){
                    List<QuestionItemDto> items1 = new ArrayList<>();
                    items1.addAll(items);
                    question.setItems(items1);
                    question.setContent(new QuestionContentDto(content.getTitle(),content.getType(),content.getAnalysis(),content.getScore(),content.getHardGrade()));
                    questions.add(question);
                    items.clear();
                    break;
                }
                Cell cell = sheet.getRow(j).getCell(0);
                if ((int) cell.getNumericCellValue() == 0) {
                    List<QuestionItemDto> items1 = new ArrayList<>();
                    items1.addAll(items);
                    question.setItems(items1);
                    question.setContent(new QuestionContentDto(content.getTitle(),content.getType(),content.getAnalysis(),content.getScore(),content.getHardGrade()));
                    questions.add(question);
                    items.clear();
                }
                continue;
            }
        }
        return questions;
    }

    /**
     * 导出excel
     * @param list
     */
    public void WriteExcel(List<QuestionDto>list) throws FileNotFoundException {
            Workbook wb =null;
        try {
            wb=new XSSFWorkbook();
            Sheet sheet = wb.createSheet();
            int temp=0;
            int counts=0;
            for (int i=0;i<list.size();i++){
                int state = 0;
                QuestionDto questionDto = list.get(i);
                if (questionDto.getItems()!=null) {
                    for (int j = 0; j <= questionDto.getItems().size(); j++) {
                        counts++;
                        int m = temp;
                        Row row = sheet.createRow(j + m);
                        if (state == 0) {
                            QuestionContentDto content = list.get(i).getContent();
                            row.createCell(0).setCellValue(0);
                            row.createCell(1).setCellValue(content.getTitle());
                            row.createCell(2).setCellValue(content.getType());
                            row.createCell(3).setCellValue(content.getAnalysis());
                            row.createCell(4).setCellValue(content.getScore());
                            row.createCell(5).setCellValue(content.getHardGrade());
                            if (questionDto.getItems() != null) {
                                state = 1;
                                continue;
                            }
                        }
                        if (state == 1) {
                            row.createCell(0).setCellValue(1);
                            row.createCell(1).setCellValue(questionDto.getItems().get(j - 1).getContent());
                            row.createCell(2).setCellValue(questionDto.getItems().get(j - 1).getIsAnswer());
                        }
                    }
                }else {
                    counts++;
                    int m = temp;
                    Row row = sheet.createRow(m);
                    QuestionContentDto content = list.get(i).getContent();
                    row.createCell(0).setCellValue(0);
                    row.createCell(1).setCellValue(content.getTitle());
                    row.createCell(2).setCellValue(content.getType());
                    row.createCell(3).setCellValue(content.getAnalysis());
                    row.createCell(4).setCellValue(content.getScore());
                    row.createCell(5).setCellValue(content.getHardGrade());
                }
                temp=counts;
            }
            wb.write(new FileOutputStream("D:\\111\\test3.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void swap(int a,int b){
        int temp =a;
        a=b;
        b=temp;
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}
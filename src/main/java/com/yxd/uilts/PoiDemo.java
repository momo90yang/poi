package com.yxd.uilts;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.yxd.entity.Item;
import com.yxd.entity.Question;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PoiDemo {
    public List<Question> excelInput(String path){
        List<Question> list = new ArrayList<>();
        Workbook wb = null;
        try {
            InputStream is = new FileInputStream(path);
            wb=new XSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 0;i<sheet.getLastRowNum()+1;i++){
                Row row = sheet.getRow(i);
                if (i<1){
                    System.out.print(row.getCell(0).getStringCellValue()+"\t"+row.getCell(1).getStringCellValue()+"\t" +row.getCell(2).getStringCellValue());
                    System.out.println(sheet.getLastRowNum());
                    continue;
                }
                Question question = new Question();
                row.getCell(0).setCellType(CellType.STRING);
                row.getCell(1).setCellType(CellType.STRING);
                row.getCell(2).setCellType(CellType.STRING);
                row.getCell(3).setCellType(CellType.STRING);
                row.getCell(4).setCellType(CellType.STRING);
                row.getCell(5).setCellType(CellType.STRING);
                row.getCell(6).setCellType(CellType.STRING);
                question.setContent(row.getCell(0).getStringCellValue());
                question.setType(row.getCell(1).getStringCellValue());
                question.setAnalysis(row.getCell(2).getStringCellValue());
                question.setScore(row.getCell(3).getStringCellValue());
                question.setHardGrade(row.getCell(4).getStringCellValue());
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("content",row.getCell(5).getStringCellValue());
                jsonObject.put("is_answer",row.getCell(6).getStringCellValue());
                JSONArray jsonArray = new JSONArray();
                jsonArray.add(jsonObject);
                List<Item> list1 = jsonArray.toJavaList(Item.class);
                question.setItems(list1);
                list.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

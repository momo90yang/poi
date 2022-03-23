package com.yxd;

import com.alibaba.fastjson.JSONArray;
import com.yxd.dto.ListNode;
import com.yxd.dto.QuestionDto;
import com.yxd.entity.Question;
import com.yxd.uilts.ExcelUtils;
import com.yxd.uilts.PoiDemo;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PoiApplicationTests {

    @Test
    void contextLoads() {
        PoiDemo pd = new PoiDemo();
        //导入操作
        List<Question> questionList= pd.excelInput("D:\\111\\test.xlsx");
        System.out.println();
        for (Question temp : questionList){
            System.out.println(temp.getContent()+"\t"+temp.getType()+"\t"+temp.getAnalysis()+"\t"+temp.getScore()+"\t"+temp.getHardGrade()+"\t"+temp.getItems());
        }
    }
    @Test
    void test1(){
        String st = "[{name:Tim,age:25,sex:male},{name:Tom,age:28,sex:male},{name:Lily,age:15,sex:female}]";
        System.out.println(st);
        JSONArray objects = JSONArray.parseArray(st);
        System.out.println(objects);
    }
    @Test
    void test2() throws IOException {
        ExcelUtils excelUtils = new ExcelUtils();
        List<QuestionDto> questionDtos = excelUtils.importExcel("D:\\111\\test2.xlsx");
        for (QuestionDto questionDto : questionDtos) {
            System.out.println(questionDto);
        }
    }
    @Test
    void Test3() throws IOException {
        ExcelUtils excelUtils = new ExcelUtils();
        List<QuestionDto> questionDtos = excelUtils.importExcel("D:\\111\\test2.xlsx");
        excelUtils.WriteExcel(questionDtos);
    }
    @Test
    void Test4(){
        int num1=10;
        int num2=20;
        ExcelUtils.swap(num1,num2);
        System.out.println("num1="+num1);
        System.out.println("num2="+num2);
    }
    @Test
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        l1.getClass();
        l2.getClass();
        //需要先把l1,l2
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        int temp=l1.getVal()+l1.getVal();
        ListNode listNodeNext = addTwoNumbers(l1.getNext(), l2.getNext());
        if (temp>10){
            temp-=10;
            listNodeNext=addTwoNumbers(listNodeNext,new ListNode(1));
        }
        return listNodeNext;
    }


}

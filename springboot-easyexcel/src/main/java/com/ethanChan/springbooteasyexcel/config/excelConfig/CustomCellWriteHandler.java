package com.ethanChan.springbooteasyexcel.config.excelConfig;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.CellData;
import com.alibaba.excel.metadata.data.HyperlinkData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

/**
 * @ClassName CustomCellWriteHandler.java
 * @Description 实现CellWriteHandler接口, 实现对单元格样式的精确控制
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-09 18:02
 */
public class CustomCellWriteHandler implements CellWriteHandler {

    /**
     * 创建单元格之前的操作
     */
    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row,
                                 Head head, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    /**
     * 创建单元格之后的操作
     */
    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell,
                                Head head, Integer integer, Boolean aBoolean) {

    }

    /**
     * 单元格内容转换之后的操作
     */
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
                                       CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    /**
     * 单元格处理后(已写入值)的操作
     */
    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
                                 List<WriteCellData<?>> list, Cell cell, Head head, Integer integer, Boolean isHead) {

        // 设置超链接
        if (isHead && cell.getRowIndex() == 0 && cell.getColumnIndex() == 0) {
            CreationHelper helper = writeSheetHolder.getSheet().getWorkbook().getCreationHelper();
            Hyperlink hyperlink = helper.createHyperlink(HyperlinkData.HyperlinkType.URL.getValue());
            hyperlink.setAddress("https://github.com/alibaba/easyexcel");
            cell.setHyperlink(hyperlink);
        }

        // 精确设置单元格格式
        boolean bool = isHead && cell.getRowIndex() == 1;
        if (bool) {
            // 获取工作簿
            Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
            CellStyle cellStyle = workbook.createCellStyle();

            Font cellFont = workbook.createFont();
            cellFont.setBold(Boolean.TRUE);
            cellFont.setFontHeightInPoints((short) 14);
            cellFont.setColor(IndexedColors.SEA_GREEN.getIndex());
            cellStyle.setFont(cellFont);
            cell.setCellStyle(cellStyle);
        }
    }
}

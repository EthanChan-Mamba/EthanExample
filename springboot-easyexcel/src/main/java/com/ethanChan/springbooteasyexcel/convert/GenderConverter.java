package com.ethanChan.springbooteasyexcel.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.CellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @ClassName GenderConverter.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-09 17:34
 */
public class GenderConverter implements Converter<Integer> {

    private static final String MAN = "男";
    private static final String WOMAN = "女";


    @Override
    public Class<?> supportJavaTypeKey() {
        // 实体类中对象属性类型
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        // Excel中对应的CellData属性类型
        return CellDataTypeEnum.STRING;
    }

    public Integer convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty,
                                     GlobalConfiguration globalConfiguration) {
        // 从Cell中读取数据
        String gender = cellData.getStringValue();
        // 判断Excel中的值，将其转换为预期的数值
        if (MAN.equals(gender)) {
            return 0;
        } else if (WOMAN.equals(gender)) {
            return 1;
        }
        return null;
    }

    @Override
    public WriteCellData<?> convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty,
                                               GlobalConfiguration globalConfiguration) {
        // 判断实体类中获取的值，转换为Excel预期的值，并封装为CellData对象
        if (integer == null) {
            return new WriteCellData<>("");
        } else if (integer == 0) {
            return new WriteCellData<>(MAN);
        } else if (integer == 1) {
            return new WriteCellData<>(WOMAN);
        }
        return new WriteCellData<>("");
    }
}

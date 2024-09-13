package com.situ.chronicmange.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/*
* 代码生成器
* */
public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1/chronic_manage", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("admin") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://code"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.situ") // 设置父包名
                            .moduleName("chronicmanage") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://code")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
//                    builder.addInclude("rhr") // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}

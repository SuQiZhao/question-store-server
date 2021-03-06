/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.geekidea.springbootplus.test;

/**
 * spring-boot-plus代码生成器入口类
 *
 * @author geekidea
 * @date 2019-10-22
 **/
public class SpringBootPlusGenerator {

    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();
        // 公共配置
        // 数据库配置
        codeGenerator
                .setUserName("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver")
                .setDriverUrl("jdbc:mysql://localhost:3306/question_store?useUnicode=true&characterEncoding=UTF-8&useSSL=false");

//        codeGenerator
//                .setUserName("spring_boot_plus")
//                .setPassword("Oracle111")
//                .setDriverName("oracle.jdbc.driver.OracleDriver")
//                .setDriverUrl("jdbc:oracle:thin:@192.168.43.204:1521:orcl");

        // 包信息
        codeGenerator
                .setProjectPackagePath("com/suqizhao")
                .setParentPackage("com.suqizhao");

        // 组件作者等配置
        codeGenerator
                .setModuleName("questionStore")
                .setAuthor("sqizhao")
                .setPkIdColumnName("cd_id");

        // 生成策略
        codeGenerator
                .setGeneratorStrategy(CodeGenerator.GeneratorStrategy.ALL)
                .setPageListOrder(true)
                .setParamValidation(true);

        // 生成实体映射相关代码,可用于数据库字段更新
        // 当数据库字段更新时，可自定义自动生成哪些文件
        codeGenerator
                .setGeneratorEntity(true)
                .setGeneratorPageParam(true)
                .setGeneratorQueryVo(true);

        // 生成业务相关代码
        codeGenerator
                .setGeneratorController(false)
                .setGeneratorService(false)
                .setGeneratorServiceImpl(false)
                .setGeneratorMapper(false)
                .setGeneratorMapperXml(false);

        // 是否生成Shiro RequiresPermissions注解
        codeGenerator.setRequiresPermissions(false);

        // 是否覆盖已有文件
        codeGenerator.setFileOverride(true);

        // 初始化公共变量
        codeGenerator.init();

        // 需要生成的表数组
        // xxx,yyy,zzz为需要生成代码的表名称
        String[] tables = {
                "user"
        };

        // 循环生成
        for (String table : tables) {
            // 设置需要生成的表名称
            codeGenerator.setTableName(table);
            // 生成代码
            codeGenerator.generator();
        }

    }

}

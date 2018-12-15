/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demo.conf

import freemarker.template.TemplateException
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver

import java.io.IOException

@Configuration
class MvcConfig : WebMvcConfigurer {

    @Bean
    fun viewResolver(): ViewResolver {
        val freeMarkerViewResolver = FreeMarkerViewResolver()
        freeMarkerViewResolver.isCache = true
        freeMarkerViewResolver.setPrefix("")
        freeMarkerViewResolver.setSuffix(".ftl")
        freeMarkerViewResolver.setContentType("text/html; charset=utf-8")
        return freeMarkerViewResolver
    }

    @Bean
    @Throws(IOException::class, TemplateException::class)
    fun freeMarkerConfigurer(): FreeMarkerConfigurer {
        val freeMarkerConfigurationFactory = FreeMarkerConfigurationFactory()
        freeMarkerConfigurationFactory.setTemplateLoaderPaths("classpath:templates", "src/main/resources/templates")
        freeMarkerConfigurationFactory.setDefaultEncoding("utf-8")
        val freeMarkerConfigurer = FreeMarkerConfigurer()
        freeMarkerConfigurer.configuration = freeMarkerConfigurationFactory.createConfiguration()
        return freeMarkerConfigurer
    }
}

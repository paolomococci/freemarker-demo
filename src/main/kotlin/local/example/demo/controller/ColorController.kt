/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demo.controller

import local.example.demo.model.Color
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import java.util.ArrayList

@Controller
class ColorController {

    @RequestMapping(value = ["/color", "/color.html"], method = [RequestMethod.GET])
    fun color(@ModelAttribute("model") modelMap: ModelMap): String {
        modelMap.addAttribute("colorList", colorList)
        return "color"
    }

    @RequestMapping(value = ["/add", "/add.html"], method = [RequestMethod.POST])
    fun add(@ModelAttribute("color") color: Color?): String {
        if (color?.code != null
                && null != color.name
                && !color.code!!.isEmpty()
                && !color.name!!.isEmpty()) {
            synchronized(colorList) {
                colorList.add(color)
            }
        }
        return "redirect:color"
    }

    companion object {

        private val colorList = ArrayList<Color>()

        init {
            colorList.add(Color(code = "#006400", name = "dark green"))
            colorList.add(Color(code = "#008080", name = "teal"))
            colorList.add(Color(code = "#2e8b57", name = "sea green"))
            colorList.add(Color(code = "#00ced1", name = "dark turquoise"))
            colorList.add(Color(code = "#00ffff", name = "aqua"))
            colorList.add(Color(code = "#7fffd4", name = "aquamarine"))
            colorList.add(Color(code = "#8b0000", name = "dark red"))
            colorList.add(Color(code = "#b22222", name = "fire brick"))
            colorList.add(Color(code = "#dc143c", name = "crimson"))
            colorList.add(Color(code = "#4169e1", name = "royal blue"))
            colorList.add(Color(code = "#9932cc", name = "dark orchid"))
            colorList.add(Color(code = "#a0522d", name = "sienna"))
            colorList.add(Color(code = "#008b8b", name = "dark cyan"))
            colorList.add(Color(code = "#dda0dd", name = "plum"))
        }
    }
}

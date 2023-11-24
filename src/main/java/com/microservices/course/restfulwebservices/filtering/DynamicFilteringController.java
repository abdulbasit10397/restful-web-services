package com.microservices.course.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DynamicFilteringController {

    @GetMapping("/dynamic-filtering-way-1")
    public MappingJacksonValue getSomeBean() {
        DynamicFilterBean dynamicFilterBean = new DynamicFilterBean("value 1", "value 2", "value 3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilterBean", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicFilterBean);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/dynamic-filtering-way-2")
    public MappingJacksonValue getSomeListOfBean() {
        List<DynamicFilterBean> dynamicFilterBeanList =
                Arrays.asList(
                        new DynamicFilterBean("value 1", "value 2", "value 3"),
                        new DynamicFilterBean("value 4", "value 5", "value 6"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilterBean", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicFilterBeanList);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }


}

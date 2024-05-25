package org.adaschool.Weather.controller;

import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WeatherReportController.class)

public class WeatherReportControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherReportService weatherReportService;

    @Test
    public void getWeatherReport() throws Exception {
        double latitude = 14.607601766197952;
        double longitude = -90.52552523303402;

        WeatherReport report = new WeatherReport();
        report.setHumidity(70.0);
        report.setTemperature(0.0);
        when(weatherReportService.getWeatherReport(latitude,longitude)).thenReturn(report);
        WeatherReport response = weatherReportService.getWeatherReport(latitude,longitude);
        assertEquals(report.getTemperature(), response.getTemperature());
        assertEquals(report.getHumidity(), response.getHumidity());

    }

}

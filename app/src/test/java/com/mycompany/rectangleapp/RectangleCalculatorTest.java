package com.mycompany.rectangleapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RectangleCalculatorTest {
    @Mock
    Rectangle rectangle;

    RectangleCalculator rectangleCalculator;

    @Test
    void testRectangleDependency(){
        //test mocked Rectangle object was created, assert object is not null
        assertThat(rectangle).isNotNull();
    }

    @BeforeEach
    void setUp(){
        rectangleCalculator=new RectangleCalculator(rectangle);
    }


    @Test
    void testThatSpecifiedDimensionsReturnsExpectedArea(){
        //Configuring return values
        when(rectangle.getLength()).thenReturn(5.0);
        when(rectangle.getBreadth()).thenReturn(4.0);

        double expected=20.0;
        double actual=rectangleCalculator.calculateArea().getArea();

        assertThat(actual).isEqualTo(expected);
    }
}


package com.mycompany.rectangleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayArea(View view) {
        //Get an instance of each EditText object using assigned ids
        EditText lengthEditText=findViewById(R.id.edittext1);
        EditText breadthEditText=findViewById(R.id.edittext2);

        //Check if any of the EditText is empty
        boolean isEmpty=validateEditText(lengthEditText,breadthEditText);

        //If any of the EditText is empty, exit method
        if(isEmpty) {
            return; //Code aborts the execution of codes in a method
        }

        //Get inputted dimensions from EditText object
        String lengthText=lengthEditText.getText().toString();
        String breadthText=breadthEditText.getText().toString();

        //Convert inputted dimensions to dimensions of type double
        double length=Double.parseDouble(lengthText);
        double breadth=Double.parseDouble(breadthText);

        //Construct rectangle object using inputted dimensions, store reference in variable of type Rectangle
        Rectangle rectangle=new Rectangle(length, breadth);

        //Construct rectangle calculator object
        RectangleCalculator rectangleCalculator=new RectangleCalculator(rectangle);

        //Calculate area using calculateArea method of the rectangle calculator object, store area in variable of type double
        double area=rectangleCalculator.calculateArea().getArea();

        //Convert area of type double to area of type String
        String text=String.valueOf(area);

        //Display area as toast
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public boolean validateEditText(EditText lengthEditText, EditText breadthEditText) {
        //Set default value of variable
        boolean isEmpty=false;

        //Set validation message
        String validationMessage="This field cannot be empty";

        //Get inputted dimensions from EditText object
        String lengthText=lengthEditText.getText().toString();
        String breadthText=breadthEditText.getText().toString();

        //Check if EditText is empty using the logic of checking if returned string is empty
        boolean lengthEditTextIsEmpty= TextUtils.isEmpty(lengthText);
        boolean breadthEditTextIsEmpty=TextUtils.isEmpty(breadthText);

        //Show validation message if any of the EditText is empty
        if (lengthEditTextIsEmpty){
            lengthEditText.setError(validationMessage); //Show validation message in EditText
            isEmpty=true; //Indicate that one of the EditTexts is empty
        }

        if (breadthEditTextIsEmpty) {
            breadthEditText.setError(validationMessage); //Show validation message in EditText
            isEmpty=true; //Indicate that one of the EditTexts is empty
        }

        //Returned boolean value
        return isEmpty;
    }

}
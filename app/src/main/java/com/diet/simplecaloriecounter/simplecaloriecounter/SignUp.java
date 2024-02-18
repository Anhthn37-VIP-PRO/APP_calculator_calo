package com.diet.simplecaloriecounter.simplecaloriecounter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class SignUp extends AppCompatActivity {

    private String[] arraySpinnerDOBDay = new String[31];
    private String[] arraySpinnerDOBYear = new String[100];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        int human_counter = 0;
        for(int x=0;x<31;x++){
            human_counter=x+1;
            this.arraySpinnerDOBDay[x] = "" + human_counter;
        }
        Spinner spinnerDOBDay = findViewById(R.id.spinnerDOBDate);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinnerDOBDay);
        spinnerDOBDay.setAdapter(adapter);


        int year = Calendar.getInstance().get(Calendar.YEAR);
        int end = year-100;
        int index = 0;
        for(int x=year;x>end;x--){
            this.arraySpinnerDOBYear[index] = "" + x;
            index++;
        }

        Spinner spinnerDOBYear = findViewById(R.id.spinnerDOBYear);
        ArrayAdapter<String> adapterYear = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinnerDOBYear);
        spinnerDOBYear.setAdapter(adapterYear);


        ImageView imageViewError = findViewById(R.id.imageViewError);
        imageViewError.setVisibility(View.GONE);

        TextView textViewErrorMessage = findViewById(R.id.textViewErrorMessage);
        textViewErrorMessage.setVisibility(View.GONE);

        EditText editTextHeightInches = findViewById(R.id.editTextHeightInches);
        editTextHeightInches.setVisibility(View.GONE);

        Spinner spinnerMesurment = findViewById(R.id.spinnerMesurment);
        spinnerMesurment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                mesurmentChanged();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        //hidingError();



        Button buttonSignUpGoal = findViewById(R.id.buttonSignUpGoal);
        buttonSignUpGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpGoalSubmit();
            }
        });
    }
    public void signUpGoalSubmit(){

        //Error
        ImageView imageViewError = findViewById(R.id.imageViewError);
        TextView textViewErrorMessage = findViewById(R.id.textViewErrorMessage);
        String errorMessage = "";

        //CurrentWeight
        EditText editTextCurrentWeight=findViewById(R.id.editTextWeight);
        String stringCurrentWeight=editTextCurrentWeight.getText().toString();
        double doubleCurrentWeight = 0;
        try{
            doubleCurrentWeight = Double.parseDouble(stringCurrentWeight);
        }catch (NumberFormatException nfe){
            errorMessage = "Target Weight has to be a number";
        }

        //TargetWeight
        EditText editTextTargetWeight = findViewById(R.id.editTextTargetWeight);
        String stringTargetWeight = editTextTargetWeight.getText().toString();
        double doubleTargetWeight = 0;
        try{
            doubleTargetWeight = Double.parseDouble(stringTargetWeight);
        }catch (NumberFormatException nfe){
            errorMessage = "Target Weight has to be a number";
        }

        //Iwantto
        Spinner spinneriWantTo = findViewById(R.id.spinneriWantTo);
        int intspinneriWantTo = spinneriWantTo.getSelectedItemPosition();

        try {
            if((doubleCurrentWeight<doubleTargetWeight&&intspinneriWantTo==0)||(doubleCurrentWeight>doubleTargetWeight&&intspinneriWantTo==1)){
                throw new ArithmeticException("not valid");}
        } catch (ArithmeticException ex) {
            errorMessage = "Vui lòng chọn lại mong muốn tăng hoặc giảm cân";
        }

        //WeeklyGoal
        Spinner spinnerWeeklyGoal = findViewById(R.id.spinnerWeeklyGoal);
        String StringspinnerWeeklyGoal = spinnerWeeklyGoal.getSelectedItem().toString();

        // Email
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        String stringEmail = editTextEmail.getText().toString();
        if(stringEmail.isEmpty() || stringEmail.startsWith(" ")){
            errorMessage = "Please fill inn an e-mail address.";
        }

        // Date of Birth Day
        Spinner spinnerDOBDay = findViewById(R.id.spinnerDOBDate);
        String stringDOBDay = spinnerDOBDay.getSelectedItem().toString();
        int intDOBDay = 0;
        try {
            intDOBDay = Integer.parseInt(stringDOBDay);

            if(intDOBDay < 10){
                stringDOBDay = "0" + stringDOBDay;
            }

        }
        catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
            errorMessage = "Please select a day for your birthday.";
        }

        // Date of Birth Month
        Spinner spinnerDOBMonth = findViewById(R.id.spinnerDOBMonth);
        String stringDOBMonth = spinnerDOBMonth.getSelectedItem().toString();
        if(stringDOBMonth.startsWith("Jan")){
            stringDOBMonth = "01";
        }
        else if(stringDOBMonth.startsWith("Feb")) {
            stringDOBMonth = "02";
        }
        else if(stringDOBMonth.startsWith("Mar")){
            stringDOBMonth = "03";
        }
        else if(stringDOBMonth.startsWith("Apr")){
            stringDOBMonth = "04";
        }
        else if(stringDOBMonth.startsWith("May")){
            stringDOBMonth = "05";
        }
        else if(stringDOBMonth.startsWith("Jun")){
            stringDOBMonth = "06";
        }
        else if(stringDOBMonth.startsWith("Jul")){
            stringDOBMonth = "07";
        }
        else if(stringDOBMonth.startsWith("Aug")){
            stringDOBMonth = "08";
        }
        else if(stringDOBMonth.startsWith("Sep")){
            stringDOBMonth = "09";
        }
        else if(stringDOBMonth.startsWith("Oct")){
            stringDOBMonth = "10";
        }
        else if(stringDOBMonth.startsWith("Nov")){
            stringDOBMonth = "11";
        }
        else if(stringDOBMonth.startsWith("Dec")){
            stringDOBMonth = "12";
        }


        // Date of Birth Year
        Spinner spinnerDOBYear = findViewById(R.id.spinnerDOBYear);
        String stringDOBYear = spinnerDOBYear.getSelectedItem().toString();
        int intDOBYear = 0;
        try {
            intDOBYear = Integer.parseInt(stringDOBYear);
        }
        catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
            errorMessage = "Please select a year for your birthday.";
        }
        String dateOfBirth = intDOBYear + "-" + stringDOBMonth + "-" + stringDOBDay;

        // Gender
        RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
        int radioButtonID = radioGroupGender.getCheckedRadioButtonId();
        View radioButtonGender = radioGroupGender.findViewById(radioButtonID);
        int position = radioGroupGender.indexOfChild(radioButtonGender);
        String stringGender = "";
        if(position == 0){
            stringGender = "male";
        }
        else{
            stringGender = "female";
        }

        // Height //
        EditText editTextHeightCm = findViewById(R.id.editTextHeightCm);
        EditText editTextHeightInches = findViewById(R.id.editTextHeightInches);
        String stringHeightCm = editTextHeightCm.getText().toString();
        String stringHeightInches = editTextHeightInches.getText().toString();

        double heightCm = 0;
        double heightFeet = 0;
        double heightInches = 0;
        boolean metric = true;


        Spinner spinnerMesurment = findViewById(R.id.spinnerMesurment);
        String stringMesurment = spinnerMesurment.getSelectedItem().toString();

        int intMesurment = spinnerMesurment.getSelectedItemPosition();
        if(intMesurment == 0){
            stringMesurment = "metric";
        }
        else{
            stringMesurment = "imperial";
            metric = false;
        }

        if(metric == true) {


            try {
                heightCm = Double.parseDouble(stringHeightCm);
                heightCm = Math.round(heightCm);
            }
            catch(NumberFormatException nfe) {
                errorMessage = "Height (cm) has to be a number.";
            }
        }
        else {


            try {
                heightFeet = Double.parseDouble(stringHeightCm);
            }
            catch(NumberFormatException nfe) {
                errorMessage = "Height (feet) has to be a number.";
            }


            try {
                heightInches = Double.parseDouble(stringHeightInches);
            }
            catch(NumberFormatException nfe) {
                errorMessage = "Height (inches) has to be a number.";
            }

            heightCm = ((heightFeet * 12) + heightInches) * 2.54;
            heightCm = Math.round(heightCm);
        }

        // Weight
        EditText editTextWeight = findViewById(R.id.editTextWeight);
        String stringWeight = editTextWeight.getText().toString();
        double doubleWeight = 0;
        try {
            doubleWeight = Double.parseDouble(stringWeight);
        }
        catch(NumberFormatException nfe) {
            errorMessage = "Weight has to be a number.";
        }
        if(metric == true) {
        }
        else{
            doubleWeight = Math.round(doubleWeight*0.45359237);
        }


        //ActivityLevel
        Spinner spinnerActivityLevel = findViewById(R.id.spinnerActivityLevel);
        int intActivityLevel = spinnerActivityLevel.getSelectedItemPosition();


        if(errorMessage.isEmpty()){
            Toast.makeText(this,  "Đéo hiểu kiểu gì?", Toast.LENGTH_SHORT).show();

            imageViewError.setVisibility(View.GONE);
            textViewErrorMessage.setVisibility(View.GONE);

            DBAdapter db = new DBAdapter(this);
            db.open();

            String stringEmailSQL = db.quoteSmart(stringEmail);
            String dateOfBirthSQL = db.quoteSmart(dateOfBirth);
            String stringGenderSQL = db.quoteSmart(stringGender);
            double heightCmSQL = db.quoteSmart(heightCm);
            int intActivityLevelSQL = db.quoteSmart(intActivityLevel);
            double doubleWeightSQL = db.quoteSmart(doubleWeight);
            String stringMesurmentSQL = db.quoteSmart(stringMesurment);

            // Insert users
            String stringInput = "NULL, " + stringEmailSQL + "," + dateOfBirthSQL + "," + stringGenderSQL + "," + heightCmSQL + "," + intActivityLevelSQL + "," + stringMesurmentSQL;
            db.insert("users", "_id,user_email,user_dob,user_gender,user_height,user_activity_level,user_mesurment",stringInput);


            //Insert Goal
            int year = Calendar.getInstance().get(Calendar.YEAR);
            int month = Calendar.getInstance().get(Calendar.MONTH);
            ++month;
            int date = Calendar.getInstance().get(Calendar.DATE);
            String goal_date = year + "-" + month + "-" + date;
            String goal_dateSQL = db.quoteSmart(goal_date);

            stringInput = "NULL, " + doubleWeightSQL + "," + goal_dateSQL + "," + intActivityLevelSQL;
            db.insert("goal", "_id,goal_current_weight,goal_date,goal_activity_level",stringInput);


            long rowId = 1;
            double doubleTargetWeightSQL = db.quoteSmart(doubleTargetWeight);
            db.update("goal", "_id", rowId, "goal_target_weight", doubleTargetWeightSQL);

            int intspinneriWantToSQL = db.quoteSmart(intspinneriWantTo);
            db.update("goal", "_id", rowId, "goal_i_want_to", intspinneriWantToSQL);

            String StringspinnerWeeklyGoalSQL = db.quoteSmart(StringspinnerWeeklyGoal);
            db.update("goal", "_id", rowId, "goal_weekly_goal", StringspinnerWeeklyGoalSQL);


            // Calculating energy
            String[] fields = new String[]{
                    "_id",
                    "user_dob",
                    "user_gender",
                    "user_height",
                    "user_activity_level"
            };

            Cursor c = db.selectPrimaryKey("users", "_id", rowId, fields);
            String stringUserDob = c.getString(1);
            String stringUserGender = c.getString(2);
            String stringUserHeight = c.getString(3);
            String stringUserActivityLevel = c.getString(4);

            String[] fieldsGoal = new String[]{
                    "_id",
                    "goal_current_weight"
            };
            Cursor cGoal = db.selectPrimaryKey("goal","_id", rowId, fieldsGoal);
            String stringUserCurrentWeight = cGoal.getString(1);

            double doubleUserCurrentWeight = 0;
            try{
                doubleUserCurrentWeight = Double.parseDouble(stringUserCurrentWeight);
            }
            catch(NumberFormatException nfe) {
                System.out.println("Could not parse " + nfe);
            }
            String[] items1 = stringUserDob.split("-");
            String stringUserAge;



            stringUserAge = getAge(year, month, date);


            /////BMR////
            double BMR = 0;
            ///BMR for male and female/////
            if (stringUserGender.startsWith("m")) {
                BMR = 88.362 + (13.397 *doubleUserCurrentWeight ) + (4.799 * Integer.parseInt(stringUserHeight)) - (5.677 * Integer.parseInt(stringUserAge));//different

            } else {
                BMR = 447.593 + (9.247 *doubleUserCurrentWeight ) + (3.098 * Integer.parseInt(stringUserHeight)) - (4.330 * Integer.parseInt(stringUserAge));//different

            }
            BMR = Math.round(BMR);
            ///////////////////////////////////////////// Energy BMR
            int energyBMRSQL = (int)db.quoteSmart(BMR);
            db.update("goal", "_id", rowId, "goal_energy_BMR", energyBMRSQL);

            double proteins1 = Math.round(energyBMRSQL*0.3);
            double carbs1 = Math.round(energyBMRSQL*0.5);
            double fats1 = Math.round(energyBMRSQL*0.2);

            int proteinsSQL1 = (int)db.quoteSmart(proteins1);
            int carbsSQL1 =(int) db.quoteSmart(carbs1);
            int fatsSQL1 =(int) db.quoteSmart(fats1);

            db.update("goal", "_id", rowId, "goal_carbs_BMR", carbsSQL1);
            db.update("goal", "_id", rowId, "goal_proteins_BMR", proteinsSQL1);
            db.update("goal", "_id", rowId, "goal_fat_BMR", fatsSQL1);

            ///////////////////////////////////////////// Energy with Diet

            double doubleWeeklyGoal = Double.parseDouble(StringspinnerWeeklyGoal);
            double KcalDividedBy7 = 1100*doubleWeeklyGoal;

            ////Tăng cân hoặc giảm cân////
            double energyWithDiet = 0;
            if(intspinneriWantTo == 0){
                energyWithDiet = Math.round((BMR - KcalDividedBy7) * 1.2);
            }else{
                energyWithDiet = Math.round((BMR + KcalDividedBy7) * 1.2);
            }
            int energyWithDietSQL = (int) db.quoteSmart(energyWithDiet);
            db.update("goal", "_id", rowId, "goal_energy_with_diet", energyWithDietSQL);
            double proteins2 = Math.round(energyWithDiet*0.3);
            double carbs2 = Math.round(energyWithDiet*0.5);
            double fats2 = Math.round(energyWithDiet*0.2);

            int proteinsSQL2 = (int)db.quoteSmart(proteins2);
            int carbsSQL2 =(int) db.quoteSmart(carbs2);
            int fatsSQL2 = (int)db.quoteSmart(fats2);

            db.update("goal", "_id", rowId, "goal_carbs_with_diet", carbsSQL2);
            db.update("goal", "_id", rowId, "goal_proteins_with_diet", proteinsSQL2);
            db.update("goal", "_id", rowId, "goal_fat_with_diet", fatsSQL2);

            ///////////////////////////////////////////// Energy with Activity
            double energyWithActivity = 0;
            if(stringUserActivityLevel.equals("0")){
                energyWithActivity = BMR*1.2;
            }else if(stringUserActivityLevel.equals("1")){
                energyWithActivity = BMR*1.375;
            }else if(stringUserActivityLevel.equals("2")){
                energyWithActivity = BMR*1.55;
            }else if(stringUserActivityLevel.equals("3")){
                energyWithActivity = BMR*1.725;
            }else if(stringUserActivityLevel.equals("4")){
                energyWithActivity = BMR*1.9;
            }
            energyWithActivity = Math.round(energyWithActivity);
            int energyWithActivitySQL = (int)db.quoteSmart(energyWithActivity);
            db.update("goal", "_id", rowId, "goal_energy_with_activity", energyWithActivitySQL);

            double proteins3 = Math.round(energyWithActivitySQL*0.3);
            double carbs3 = Math.round(energyWithActivitySQL*0.5);
            double fats3 = Math.round(energyWithActivitySQL*0.2);

            int proteinsSQL3 = (int)db.quoteSmart(proteins3);
            int carbsSQL3 = (int)db.quoteSmart(carbs3);
            int fatsSQL3 = (int)db.quoteSmart(fats3);

            db.update("goal", "_id", rowId, "goal_carbs_with_activity", carbsSQL3);
            db.update("goal", "_id", rowId, "goal_proteins_with_activity", proteinsSQL3);
            db.update("goal", "_id", rowId, "goal_fat_with_activity", fatsSQL3);

            ///////////////////////////////////////////// Energy with Activity and Diet
            double energyWithActivityAndDiet = 0;
            if(intspinneriWantTo == 0){
                energyWithActivityAndDiet = Math.round(BMR - KcalDividedBy7);
            }else{
                energyWithActivityAndDiet = Math.round(BMR + KcalDividedBy7);
            }
            if(stringUserActivityLevel.equals("0")) {
                energyWithActivityAndDiet= energyWithActivityAndDiet* 1.2;
            }
            else if(stringUserActivityLevel.equals("1")) {
                energyWithActivityAndDiet= energyWithActivityAndDiet* 1.375;
            }
            else if(stringUserActivityLevel.equals("2")) {
                energyWithActivityAndDiet= energyWithActivityAndDiet*1.55;
            }
            else if(stringUserActivityLevel.equals("3")) {
                energyWithActivityAndDiet= energyWithActivityAndDiet*1.725;
            }
            else if(stringUserActivityLevel.equals("4")) {
                energyWithActivityAndDiet = energyWithActivityAndDiet* 1.9;
            }
            energyWithActivityAndDiet = Math.round(energyWithActivityAndDiet);

            int energyWithActivityAndDietSQL = (int) db.quoteSmart(energyWithActivityAndDiet);
            db.update("goal", "_id", rowId, "goal_energy_with_activity_and_diet", energyWithActivityAndDietSQL);

            double proteins4 = Math.round(energyWithActivityAndDietSQL*0.3);
            double carbs4 = Math.round(energyWithActivityAndDietSQL*0.5);
            double fats4 = Math.round(energyWithActivityAndDietSQL*0.2);

            int proteinsSQL4 = (int)db.quoteSmart(proteins4);
            int carbsSQL4 = (int)db.quoteSmart(carbs4);
            int fatsSQL4 = (int) db.quoteSmart(fats4);

            db.update("goal", "_id", rowId, "goal_carbs_with_activity_and_diet", carbsSQL4);
            db.update("goal", "_id", rowId, "goal_proteins_with_activity_and_diet", proteinsSQL4);
            db.update("goal", "_id", rowId, "goal_fat_with_activity_and_diet", fatsSQL4 );

            db.close();

            Intent i = new Intent(SignUp.this, MainActivity.class);
            startActivity(i);

        }
        else {
            textViewErrorMessage.setText(errorMessage);
            imageViewError.setVisibility(View.VISIBLE);
            textViewErrorMessage.setVisibility(View.VISIBLE);
        }

    }


    public void hidingError(){
        ImageView imageViewError = findViewById(R.id.imageViewErrorGoal);
        imageViewError.setVisibility(View.GONE);

        TextView textViewErrorMessage = findViewById(R.id.textViewErrorMessageGoal);
        textViewErrorMessage.setVisibility(View.GONE);
    }

    public void measurementUsed(){
        DBAdapter db = new DBAdapter(this);
        db.open();

        long rowId = 1;
        String[] fields = new String[]{
                "_id",
                "user_mesurment"
        };

        Cursor c = db.selectPrimaryKey("users", "_id", rowId, fields);

        String measurement = c.getString(1);

        TextView textViewTargetMeasurement = findViewById(R.id.textViewTargetMesurment);
        TextView textViewTargetWeeklyGoal2 = findViewById(R.id.textViewWeeklyGoal2);

        if(measurement.startsWith("i")){
            textViewTargetMeasurement.setText("pound");
            textViewTargetWeeklyGoal2.setText("pound each week");
        }

        db.close();
    }
    private String getAge(int year, int month, int date){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, date);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            --age;
        }

        return "" + age;
    }

    public void mesurmentChanged() {


        Spinner spinnerMesurment = findViewById(R.id.spinnerMesurment);
        String stringMesurment = spinnerMesurment.getSelectedItem().toString();


        EditText editTextHeightCm = findViewById(R.id.editTextHeightCm);
        EditText editTextHeightInches = findViewById(R.id.editTextHeightInches);
        String stringHeightCm = editTextHeightCm.getText().toString();
        String stringHeightInches = editTextHeightInches.getText().toString();

        double heightCm = 0;
        double heightFeet = 0;
        double heightInches = 0;

        TextView textViewCm = findViewById(R.id.textViewCm);
        TextView textViewKg = findViewById(R.id.textViewKg);

        if(stringMesurment.startsWith("I")){

            editTextHeightInches.setVisibility(View.VISIBLE);
            textViewCm.setText("feet and inches");
            textViewKg.setText("pound");


            try {
                heightCm = Double.parseDouble(stringHeightCm);
            }
            catch(NumberFormatException nfe) {

            }
            if(heightCm != 0){

                heightFeet = heightCm/30.48;
                heightInches = (heightFeet - (int)heightFeet)*12;

                editTextHeightCm.setText("" + (int)heightFeet);
                editTextHeightInches.setText("" + (int)heightInches);

            }

        }
        else{

            editTextHeightInches.setVisibility(View.GONE);
            textViewCm.setText("cm");
            textViewKg.setText("kg");

            try {
                heightFeet = Double.parseDouble(stringHeightCm);
            }
            catch(NumberFormatException nfe) {

            }

            try {
                heightInches = Double.parseDouble(stringHeightInches);
            }
            catch(NumberFormatException nfe) {

            }

            if(heightFeet != 0 && heightInches != 0) {
                heightCm = ((heightFeet * 12) + heightInches) * 2.54;
                editTextHeightCm.setText("" + Math.round(heightCm));
            }
        }



        // Weight
        EditText editTextWeight = findViewById(R.id.editTextWeight);
        String stringWeight = editTextWeight.getText().toString();
        double doubleWeight = 0;

        try {
            doubleWeight = Double.parseDouble(stringWeight);
        }
        catch(NumberFormatException nfe) {
        }

        if(doubleWeight != 0) {

            if (stringMesurment.startsWith("I")) {

                doubleWeight = Math.round(doubleWeight / 0.45359237);
            } else {

                doubleWeight = Math.round(doubleWeight * 0.45359237);
            }
            editTextWeight.setText("" + doubleWeight);
        }

    }



}

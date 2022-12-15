package com.crm.testClassesPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice {
@Test(dataProvider="getData")
public void test2(String CityName,int PinCode) {
	System.out.println("City Name==>"+CityName);
	System.out.println("Pin Code==>"+PinCode);
}

@DataProvider
public Object[][] getData(){
	Object[][] arr=new Object[4][2];
	arr[0][0]="Bangalore";
	arr[0][1]=560058;
	arr[1][0]="Bls";
	arr[1][1]=756056;
	arr[2][0]="Vizag";
	arr[2][1]=530013;
	arr[3][0]="Bbsr";
	arr[3][1]=760067;
	return arr;
}

}

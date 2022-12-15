package com.vtiger1.genericutility;

/**
 * this enum contains sheet names of excel
 * @author jay
 *
 */
public enum SheetName {

	CREATELEADS("CreateLeads"),CONTACTS("contacts"),ORGANIZATION("organization");
	private String sheetname;
	private SheetName(String sheetname)
	{
		this.sheetname=sheetname;
	}
	public String convertToString() {
		return sheetname.toString();
	}
}

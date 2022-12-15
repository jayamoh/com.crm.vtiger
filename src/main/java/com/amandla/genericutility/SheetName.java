package com.amandla.genericutility;

/**
 * this enum contains sheet names of excel
 * @author VANNUR
 *
 */
public enum SheetName {

	CREATELEADS("CreateLeads"),CONTACTS("contacts"),ORGANIZATION("organization");
	private String sheetname;
	/**
	 * it is used to initialize sheetname
	 * @param sheetname
	 */
	private SheetName(String sheetname)
	{
		this.sheetname=sheetname;
	}
	/**
	 * it is used to return sheet name
	 * @return
	 */
	public String convertToString() {
		return sheetname.toString();
	}
}

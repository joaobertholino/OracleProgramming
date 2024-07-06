package com.joaoBertholino;
import java.util.Date;

public interface Item {
	public String manufacturer = "OraclProduction";

	public void setProductionNumber(int productionnumber);

	public void setName(String name);

	public String getName();

	public Date getManufactureDate();

	public int getSerialNumber();
}

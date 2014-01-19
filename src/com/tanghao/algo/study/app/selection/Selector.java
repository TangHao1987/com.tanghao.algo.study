package com.tanghao.algo.study.app.selection;

public abstract class Selector implements ISelector {
	protected int [] array;
	private int selectedValue;
	@Override
	public void setArray(int[] array) {
		// TODO Auto-generated method stub
		this.array = array;
	}

	@Override
	public int[] getArray() {
		// TODO Auto-generated method stub
		return array;
	}

	@Override
	public void printSelectedValue() {
		// TODO Auto-generated method stub
		System.out.println("Selected value is: " + getSelectedValue());
	}

	public int getSelectedValue() {
		return selectedValue;
	}

	protected void setSelectedValue(int selectedValue) {
		this.selectedValue = selectedValue;
	}

}

package com.tanghao.algo.study.app.selection;

public interface ISelector {
	public void setArray(int [] array);
	public int[] getArray();
	public int select(int i);
	public void printSelectedValue();
}

package com.nx.kernel.model;

import java.util.List;

import com.nx.kernel.service.NxQueryResult;

public class NxPageView<T> {
	
	private List<T> records;
	
	private NxPageIndex pageindex;
	
	private long totalpage = 1;
	
	private int maxresult = 12;
	
	private int currentpage = 1;
	
	private long totalrecord;
	
	private int pagecode = 10;
	
	public int getFirstResult() {
		return (this.currentpage-1)*this.maxresult;
	}
	public int getPagecode() {
		return pagecode;
	}

	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

	public NxPageView(int maxresult, int currentpage) {
		this.maxresult = maxresult;
		this.currentpage = currentpage;
	}
	
	public void setQueryResult(NxQueryResult<T> qr){
		setTotalrecord(qr.getTotalrecord());
		setRecords(qr.getResultlist());
	}
	
	public long getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
		setTotalpage(this.totalrecord%this.maxresult==0? this.totalrecord/this.maxresult : this.totalrecord/this.maxresult+1);
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public NxPageIndex getPageindex() {
		return pageindex;
	}
	public long getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(long totalpage) {
		this.totalpage = totalpage;
		this.pageindex = NxPageIndex.getPageIndex(pagecode, currentpage, totalpage);
	}
	public int getMaxresult() {
		return maxresult;
	}
	public int getCurrentpage() {
		return currentpage;
	}
}

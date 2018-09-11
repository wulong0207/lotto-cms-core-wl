package com.hhly.cmscore.persistence.trans.dao;

import org.apache.ibatis.jdbc.SQL;

import com.hhly.skeleton.cms.transmgr.vo.TransTakenVO;

public class TransTakenDaoProvider {

	public String findBankExcel(final TransTakenVO vo){
		  return new SQL() {{
			    SELECT("BANK_CARD_NUM bankCardNum,ACTUAL_NAME actualName,EXTRACT_AMOUNT extractAmount,TAKEN_BANK takenBank,BANK_INFO bankInfo,BATCH_NUM batchNum");
			    FROM("TRANS_TAKEN tt");
			    LEFT_OUTER_JOIN("M_USER_INFO lc on tt.user_id=lc.id");
			    WHERE("tt.trans_status = #{transStatus}");
			    WHERE(String.format("tt.id in %s", vo.getIds()).replace("[", "(").replace("]", ")"));
			  }}.toString();
	}
}

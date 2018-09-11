package com.hhly.cmscore.persistence.order.po;

import org.junit.Test;

/**
 * 
 * @author longguoyou

 * @date 2017年2月5日 下午4:18:39

 * @desc 验证属性相同类之间相互转化 ， 使用工具类BeanUtils.copyProperties(source,target);
 *
 */
public class OrderInfoPOTest {
	
	//@Test
	/*public void test2(){
		String content = "161128001[+1](3@1.57,0@2.27)#161128002[+1](1@1.89,0@4.21)|161128003[+1](0@4.21)^2_1,3_1";
		System.out.println(content.split(",").length);
		Array[] arr = null;
		OrderPluginFootball[] arr1 = new OrderPluginFBJCBF[3];
		OrderPluginFootball opf = new OrderPluginFBJCBF();
		System.out.println(NullUtil.isNullObject(opf));
		System.out.println(NullUtil.isNullArray(arr));
		System.out.println(NullUtil.isNullArray(arr1));
		System.out.println(SportEnum.SportFbSubWay.JCZQ_M.getValue());
//		String con = content.substring(content.lastIndexOf(",")+1);
//		System.out.println(con);
	}*/
	
	@Test
	public void test1(){
		/*OrderPluginFootball opf = new OrderPluginFBJCBF();
		OrderPluginFootball opf1= new OrderPluginFBJCBQC();
		OrderPluginFootball opf2= new OrderPluginFBJCHT();
		OrderPluginFootball opf3= new OrderPluginFBJCRSPF();
		OrderPluginFootball opf4= new OrderPluginFBJCSPF();
		OrderPluginFootball opf5= new OrderPluginFBJCZJQ();*/
//		opf.orderValidate(new OrderInfoVO(), new OrderInfoPO(),new OrderDetailVO(),new OrderDetailPO(), new HashMap());
//		opf1.orderValidate(new OrderInfoVO(), new OrderInfoPO(),new OrderDetailVO(),new OrderDetailPO(), new HashMap());
//		opf2.orderValidate(new OrderInfoVO(), new OrderInfoPO(),new OrderDetailVO(),new OrderDetailPO(), new HashMap());
//		opf3.orderValidate(new OrderInfoVO(), new OrderInfoPO(),new OrderDetailVO(),new OrderDetailPO(), new HashMap());
//		opf4.orderValidate(new OrderInfoVO(), new OrderInfoPO(),new OrderDetailVO(),new OrderDetailPO(), new HashMap());
//		opf5.orderValidate(new OrderInfoVO(), new OrderInfoPO(),new OrderDetailVO(),new OrderDetailPO(), new HashMap());
	}

	@Test
	public void test() {
//		assertTrue(1==1);
	    B b = new B();
	    b.setId(10);
	    b.setName("张三");
	    b.setDh("13530381500");
	    A a = new A();
	    b.conversionTheSameProperties(b, a);
	    b.conversionTheOthersProperties(a);
		System.out.println(b);
		System.out.println(a);
	}
	
	class A extends AbstractConversionBase<A>{
		private String name;
		private Integer id;
		private String phone;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		@Override
		public String toString() {
			return "A [name=" + name + ", id=" + id + ", phone=" + phone + "]";
		}
		@Override
		public void conversionTheOthersProperties(A target) {
			
		}
	}
	
	class B extends AbstractConversionBase<A>{
		private String name;
		private Integer id;
		private String dh;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getDh() {
			return dh;
		}
		public void setDh(String dh) {
			this.dh = dh;
		}
		
		@Override
		public String toString() {
			return "B [name=" + name + ", id=" + id + ", dh=" + dh + "]";
		}
		@Override
		public void conversionTheOthersProperties(A target) {
//			A a = (A)target;
			target.setPhone(this.dh);
		}
	}

}

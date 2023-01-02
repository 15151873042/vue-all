package com.hp.demo.vuedemo.vo;

import java.text.MessageFormat;


/**
 * @ClassName: Enums
 * @Description: 错误码枚举类
 * @Author 胡鹏
 * @Date 2021/3/2 12:31
 */
public interface Enums {

	public String getCode();

	public String getDesc();
	
	public String getDesc(Object... objs);

	/**
	 * 系统码：00开头表示成功，99开头表示错误
	 */
	public enum SysCode implements Enums {
	    SUCCESS("000000", "处理成功！"),
	    GET_ERROR("990001", "获取数据失败，请刷新重试！"),
	    ADD_ERROR("990002", "插入数据失败，请刷新重试！"),
	    EDIT_ERROR("990003", "更新数据失败，请刷新重试！"),
	    DEL_ERROR("990004", "删除数据失败，请刷新重试！"),
		;

		private String code;
		private String desc;

		private SysCode(String code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		@Override
        public String getCode() {
			return code;
		}

		@Override
        public String getDesc() {
			return desc;
		}

		@Override
        public String getDesc(Object ... objs) {
			return MessageFormat.format(this.desc,objs);
		}
		
		public boolean equalsCode(String code) {
	        return this.code.equals(code);
	    }
		
		//通过value获取对应的枚举对象
        public static SysCode getEnums(String value) {
            for (SysCode code : SysCode.values()) {
                if (code.getCode().equals(value)) {
                    return code;
                }
            }
            return null;
        }
	}
}

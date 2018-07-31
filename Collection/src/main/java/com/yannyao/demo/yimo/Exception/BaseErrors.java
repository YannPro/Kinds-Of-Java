package com.yannyao.demo.yimo.Exception;

/**
 * Created by didi on 2017/7/10.
 */

/**
 * @author jsm
 */
public enum BaseErrors implements ApiErrors {
    JSON_FORMAT_ERROR(100002, "JSON格式错误", "服务器出小差了~"),
    SYSTEM_ERROR(100003, "%s", "服务器繁忙，请稍后重试"),
    POINTER_MOVE_ERROR(30000004, "指针移动错误", "服务器繁忙，请稍后重试"),
    REQUEST_PARAM_ERROR(10000004, "请求参数异常", "请求参数异常"),
    AUTH_ERROR(10000005, "权限不够", "您没有权限"),
    TCC_ERROR(10000006, "TCC异常: %s", "服务器忙，请稍后重试"),
    RELATIVE_ERROR(10000007, "关联异常", "服务器忙，请稍后重试"),
    PAYMCHJS_ERROR(10000008, "%s", "服务器忙，请稍后重试"),
    IP_NOT_IN_WHILELIST(10000009, "IP(%s)不在白名单中,无法调用，请先添加白名单", "IP不在白名单中,无法调用，请先添加白名单"),
    PAYMENT_RECORD_NOT_EXIST(10000010, "该支付记录不存在", "支付记录不存在"),
    PROTECT_INFO_HAVE_CREATE(10000011, "该订单已申请过维权", "请勿重复提交维权申请"),
    TRADE_STATUS_NOT_UNPAID(10000012, "未支付的订单才能取消", "未支付的订单才能取消"),
    MYBATIS_STRUCTURE_ERROR(10000013, "baseservice操作数据库异常", "服务器出小差了~"),
    FARE_ADDR_ERROR(10000014, "不支持该区域", "不支持该区域~"),
    CROS_ERROR(10000014, "跨服务调用异常", "跨服务调用异常~"),
    COUPON_ERROR(10000015, "优惠券异常", "优惠券异常"),
    FXPLAN_ALREADY_EXIST(10000016, "您选择的商品已存在分销商品！", "您选择的商品已存在分销商品！"),
    REQUEST_METHOD_ERROR(10000017, "不支持此请求方法！", "不支持此请求方法！"),
    SERVER_ERROR(10000018, "%s", "%s"),
    FXPLAN_MONEY_ERROR(10000019, "分销佣金不能大于商品金额！", "分销佣金不能大于商品金额！"),
    STOCK_NOT_ENOUGH(10000020, "库存不足！", "库存不足！")
    ;

    private int result;
    private String errMsg;
    private String error;
    private String[] args;
    private String[] emArgs;

    BaseErrors(int result, String error, String errMsg) {
        this.result = result;
        this.error = error;
        this.errMsg = errMsg;
    }


    public BaseErrors setArgs(String... args) {
        this.args = args;
        return this;
    }

    public BaseErrors setEmArgs(String... emargs) {
        this.emArgs = emargs;
        return this;
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public String getError() {

        if (args == null) {
            return this.error;
        } else {
            return String.format(error, args);
        }

    }

    @Override
    public String getErrMsg() {
        if (emArgs == null) {
            return this.errMsg;
        } else {
            return String.format(errMsg, emArgs);
        }
    }
}

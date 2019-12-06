package com.jiabiango.hr.wechat.controller;

/**
 * @category说明：微信支付回调
 * @author创建人：lukas @date创建时间：2017年12月26日14:53:48
 * @emial邮箱：414024003@qq.com
 */
/*@RestController
@RequestMapping(value = "/weChatPay")*/
public class WeChatPayController {

	/*private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderService orderService;
//	@Autowired
//	private OrderExtService orderExtService;
	@Autowired
	private OrderDetailsService orderdetailsService;

	@Autowired
	private MemberService memberService;
	@Autowired
	private RechargeService rechargeService;
//	@Autowired
//	private SkupluMapper skupluMapper;

	*//**
	 * 数据编码
	 *//*
	private static final String ENCODING = "UTF-8";

	*//**
	 * 元转换成分
	 * 
	 * @param money
	 * @return
	 *//*
	public static String getMoney(String amount) {
		if (amount == null) {
			return "";
		}
		// 金额转化为分为单位
		String currency = amount.replaceAll("[ +a-zA-Z\\u4e00-\\u9fa5]", ""); // 处理包含,
																				// ￥
																				// 或者$的金额
		int index = currency.indexOf(".");
		int length = currency.length();
		Long amLong = 0l;
		if (index == -1) {
			amLong = Long.valueOf(currency + "00");
		} else if (length - index >= 3) {
			amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
		} else if (length - index == 2) {
			amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
		} else {
			amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
		}
		return amLong.toString();
	}

	*//**
	 * 微信回调
	 * 
	 * @return
	 * @throws Exception
	 *//*
	@ResponseBody
	@RequestMapping(value = "/weChatPayResSample", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/xml;charset=UTF-8")
	public String weChatPayResSample(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		int result = 0;
		try {
			out = response.getWriter();
			final String notify = readNotify(request);
			final Document doc = DocumentHelper.parseText(notify);
			final Element root = doc.getRootElement();
			final String ret = root.element("return_code").getText();
			if ("SUCCESS".equals(ret) == false) {
				logger.info("weChatPayResSample:------------------------->weixin notify: return - "
						+ root.element("return_msg").getText());
				return null;
			}
			// check - result_code
			final String res = root.element("result_code").getText();
			if ("SUCCESS".equals(res) == false) {
				logger.info("weChatPayResSample:------------------------->weixin notify: return - "
						+ root.element("return_msg").getText());
				return null;
			}
			// check - sign
			final String sign = root.element("sign").getText();
			if (Sha1Util.verifySign(new StringBuilder(), new TreeMap<String, String>(), root, sign,
					WeChatConstans.partner_key) == false) {
				logger.info("返回参数异常weixin notify: sign error");
				return null;
			}
			// xid
			final String txno = root.element("out_trade_no").getText();
			final String[] attach = root.element("attach").getText().split(",");
			final String wcPayType = attach[0];
			final String openID = attach[1];// 微信用户标识
			final String xid = root.element("transaction_id").getText();
			logger.info("返回参数微信支付订单编号xid: " + xid);
			// 根据系统的订单号 去执行业务逻辑
			// 3代表充值,1代表微信支付
			if ("3".equals(wcPayType)) {	//修改充值状态，及同步中台充值
				result = updateRechargeStateAndSync(txno, xid);
				if (result == 1 || result == -2 || result == 0) {
					// 发送成功通知
					out.println(
							"<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
					out.flush();
					out.close();
				}
			} else if ("1".equals(wcPayType)) {
				// 微信支付订单
				result = updateOrderState(txno, xid);
				if (result == 1 || result == -2) {
					// 发送成功通知
					out.println(
							"<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
					out.flush();
					out.close();
				}
			}

		} catch (Exception e) {
			logger.info("weChatPayResSample----------------------------------->状态码result:" + result);
			logger.info("weChatPayResSample----------------------------------->Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	*//**
	 * 
	 * @param billNo
	 * @param xid 
	 * @return 0 同步中台失败，但是订单成功 1都是成功 -2 订单已经处理
	 * @throws Exception 
	 *//*
	private int updateRechargeStateAndSync(String billNo, String xid) throws Exception {
		RechargeDto dto = new RechargeDto();
		dto.setBillNo(billNo);
		dto.setWeixinNo(xid);
		return rechargeService.updateRechargeStateAndSync(dto);
	}

	*//**
	 * 回写订单中台以及同步中台销售订单
	 * 
	 * @param billNo
	 *            订单编号
	 * @param xid
	 *            微信支付流水号
	 * @return 1执行成功 -2 订单已支付
	 *//*
	private int updateOrderState(String billNo, String xid) {
		List<Order> orderList = new ArrayList<Order>();
		int result = updateOrder(orderList, billNo, xid);
		if (result == 1 && orderList.size() == 1) {
			Order order = orderList.get(0);
			Member member = memberService.selectByPhoneNumber(order.getMemberPhone());
			// 同步中台销售单新增
			tozhongtai(order, member.getPhoneNumber(), order.getTotalPrice().subtract(order.getPayPrice()), 1);
		}
		return result;
	}

	*//**
	 * 修改订单以及同步销售订单
	 * 
	 * @param order
	 * @param billNo
	 * @param xid
	 * @return 1执行成功
	 *//*
	private int updateOrder(List<Order> orderList, String billNo, String xid) {
		int result = 0;
		OrderDto dto = new OrderDto();
		dto.setBillNo(billNo);
		try {
			Order order = orderService.findById(dto);
			if (order == null) {
				logger.info("该订单不存在");
				// 该订单不存在
				return -1;
			}
			orderList.add(order);
			if (22 == order.getPaymentStatusId()) {
				logger.info("该订单已支付");
				// 该订单已支付
				return -2;
			}
			// 19代表提交状态为已完成
			dto.setOrderStatusId(19);
			dto.setPaymentDate(new Date());
			// 22代表支付状态为已付款
			dto.setPaymentStatusId(22);
			dto.setPaymentNo(xid);
//			orderExtService.updateOrderParams(dto, order);
			result = 1;
		} catch (Exception e) {
			result = -1;
			logger.info("回写余额支付订单状态失败订单编号BILLNO: " + billNo);
			logger.info("错误如下: " + e.toString());
			e.printStackTrace();
		}

		return result;

	}

	*//**
	 * 同步中台
	 * @param order
	 * @param phone
	 * @param denominattion
	 * @param payType
	 *//*
	private void tozhongtai(Order order, String phone, BigDecimal denominattion, int payType) {
		String nowDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		String billNo = order.getBillNo();

		try {
			OrderDto dto = new OrderDto();
			dto.setBillNo(billNo);
			 Order pd= orderService.findById(dto);

			// 无人货架的地址
//			 Store tpd = storeService.selectById(storeId); // 根据ID读取

			VEOrderRequest veOrderRequest = new VEOrderRequest();
			// 默认为0
			veOrderRequest.setSendstatus(0);
			// 默认为空
			veOrderRequest.setShopreceivedate("");
			// 当前系统时间
			veOrderRequest.setLastupdatedate(nowDate);
			// 默认为空
			veOrderRequest.setLinkuserphone("");
			// 默认当前时间
			veOrderRequest.setCreatedate(nowDate);
			// wljson默认为空
			veOrderRequest.setWljson("");
			// source默认为0
			veOrderRequest.setSource(0);
			// userid默认为空
			veOrderRequest.setUserid("");
			// pushlogisticsstatus默认0，可不传
			veOrderRequest.setPushlogisticsstatus(0);
			// 海鼎虚拟门店号
			veOrderRequest.setShopcode(order.getStoreCode());
			// 默认为空
			veOrderRequest.setCanceldesc("");
			// 默认为空
			veOrderRequest.setShopreceivedateo("");
			// 订单号
			veOrderRequest.setOrdercode(billNo);
			// 默认为空
			veOrderRequest.setFlowcompany("");

			veOrderRequest.setCreateid("");
			// 默认为空
			veOrderRequest.setPmobile("");
//			veOrderRequest.setCompanytitle(tpd.getStoreAddress());
			// 默认为空
			veOrderRequest.setId("");
			veOrderRequest.setPlat(0);
			veOrderRequest.setState(3);// ": 2, 完成是3
			veOrderRequest.setFcode("");// ": "328584374255", 空
			veOrderRequest.setCompanymobile("");// ": "0731-89609752 ",空
			veOrderRequest.setWxpayid(pd.getPaymentNo());// 余额支付默认为空
			veOrderRequest.setCommentstatus(0);// ": 0,//默认为0
			veOrderRequest.setSendtype(0);// ": 0,//默认为0
			veOrderRequest.setDateo(nowDate);// ": "2017/11/14 0:00:00",
			veOrderRequest.setCreatename(pd.getMemberName());// ": "pwL",//微信昵称
			veOrderRequest.setPlong(0);// ": 112.976914316,////默认为0
			veOrderRequest.setIsgb(0);// ": 0,//默认为0
			veOrderRequest.setBuyname(pd.getMemberName());// ": "pwL
			veOrderRequest.setAccountsprice(pd.getTotalPrice());// ":
																					// 11.11,//当前总价double
			veOrderRequest.setOrdertype(1);// ": "", 订单类型： 默认为1
			veOrderRequest.setLinkusername("");// ": "",//默认为空
			veOrderRequest.setSendername("");// ": "",//默认为空
			veOrderRequest.setSendmole(0);// ": 0, 默认0

			veOrderRequest.setDiscount(denominattion.doubleValue());

			veOrderRequest.setPaidprice(pd.getPayPrice());// ":
																				// 11.11,
																				// 实际支付的金额

			veOrderRequest.setRefoundstatus(0);// ": 0,//默认为0
			veOrderRequest.setRemark(pd.getRemarks());// ": "",//默认为空
			veOrderRequest.setRemind(0);// ": 0,//默认为0
//			veOrderRequest.setCompanyaddress(tpd.getStoreAddress());// ":
																	// "长沙市天心区书院南路423号金盆岭街道乾城嘉园负2004号",////默认为门店地址（无人货架）
			veOrderRequest.setCgstatus(0);// ": 0,//默认为0
			veOrderRequest.setLastupdateid("");// ": "",//默认为空
			veOrderRequest.setReminddate("");// ": "",//默认为空
			veOrderRequest.setGoodscount(pd.getSkuCount());// ": 1,//商品个数 总数
			veOrderRequest.setSenddate(nowDate);// ": "",//默认为当前时间"
			veOrderRequest.setPaymole(payType);// ": 1,//支付方式 1.微信，5为余额支付
			veOrderRequest.setPrintstate("0");// ": "0",//默认0
			veOrderRequest.setFlowcode("");// ": "",//默认为空
			veOrderRequest.setLastupdatename("");// ": "",//默认为空
			veOrderRequest.setBuyphone(phone);// ": "18073160309",//下单人手机号码

			veOrderRequest.setPaytime(nowDate);// ": "2017/11/14
			veOrderRequest.setPickupid("");// ":
											// "f772f4e5a1f148bebf0c3c52515f91b3",//默认为空
			veOrderRequest.setCremark("");// ": "",//默认为空
			veOrderRequest.setCompletedate(nowDate);// ": "",//默认为空
			veOrderRequest.setIspush(0);// ": 0,//默认为0
			veOrderRequest.setPayremind(0);// ": 0,//默认为0
			veOrderRequest.setDeliverytime(nowDate);// ": "1970/1/1
			veOrderRequest.setReceivecode("");// ": "",//默认为空
			veOrderRequest.setLinkuseraddress("");// ": "",//默认为空
			veOrderRequest.setPayreminddate("");// ": "",//默认为空
			veOrderRequest.setSendkind(0);// ": 0,//默认为0
			veOrderRequest.setPrintcount("0");// ": "0"//默认为0
			List<VEOrderGoodsRequest> goodList = new ArrayList<>();

			// 查询分公司代销商品列表
//			List<Integer> sellGoodslist = skupluMapper.findSellGoodsByCompanyNumber(pd.getCompanyNumber());
		 
			
			OrderdetailsDto orderdetailsDto = new OrderdetailsDto();
			orderdetailsDto.setBillNo(billNo);
			List<Orderdetails> list = orderdetailsService.findByBillNo(orderdetailsDto);
			double allPrice = 0d;
			boolean isSellGoods = false;
			int goodscount = 0;
			for (Orderdetails data : list) {
				 
				// 发生售价
				BigDecimal price = data.getPrice();
				// 总价=单商品总价累加(单商品总价=发生售价X数量)
				allPrice = Convert.add(allPrice, price.multiply(new BigDecimal(data.getSkuCount())).doubleValue());
				goodscount += data.getSkuCount();

				VEOrderGoodsRequest veOrderGoodsRequest = new VEOrderGoodsRequest();
				veOrderGoodsRequest.setIsschedule(0);// ": 0,默认为0
				veOrderGoodsRequest.setCode(data.getBarCode());// ":
																// "2101010102",商品编码
				veOrderGoodsRequest.setPrice(price.toString());// ": "11.11",单价
				veOrderGoodsRequest.setCount(data.getSkuCount());// ": 1,个数
				veOrderGoodsRequest.setGoodtype(0);// ": 0,//默认为0
				veOrderGoodsRequest.setPtitle(data.getSkuName());// ":
																	// "湘江源333ML山泉水（蓝山）件",//
				veOrderGoodsRequest.setBarcode(data.getBarCode());// ":
																	// "6921010101",
				veOrderGoodsRequest.setSpec(data.getSpec());// ": "1*12件"
				
				goodList.add(veOrderGoodsRequest);
				veOrderRequest.setJson(goodList);
			}

			// 没有商品详情订单，代表都是代销商品，订单不需要传ERP
			if (goodList.size() == 0) {
				logger.info("存在都是代销商品的订单编号：" + billNo);
				return;
			}

			if (isSellGoods) {
				veOrderRequest.setGoodscount(goodscount);// ": 1,//商品个数 总数
				veOrderRequest.setAccountsprice(BigDecimal.valueOf(allPrice));// ":
																				// 11.11,//当前总价double
				veOrderRequest.setPaidprice(BigDecimal.valueOf(allPrice));// ":
																			// 11.11,
																			// 实际支付的金额
				veOrderRequest.setDiscount(0d);
			}

			String jveOrder = JSON.toJSON(veOrderRequest).toString();
			String parameter = jveOrder;
			String url = OrderCenterConstans.ORDER_CENTER_URL;
			if (!"1".equals(url)) {
				HttpUtil.postJson(url, parameter);
			}
		} catch (Exception e) {
			logger.info("同步中台BILLNO: " + billNo);
			logger.info("错误如下: " + e.toString());
			e.printStackTrace();
		}
	}

	*//**
	 * 获取回调内容信息
	 * 
	 * @return
	 * @throws IOException
	 *//*
	private String readNotify(HttpServletRequest request) throws IOException {
		logger.debug("request content-type:" + request.getContentType() + ", content-length:"
				+ request.getContentLength() + "");
		final InputStream in = request.getInputStream();
		final Reader reader = new InputStreamReader(in, ENCODING);
		try {
			final int MAX = 1 << 12, xmlsz = "</xml>".length(); // read max 4k!
			StringBuilder sbuf = new StringBuilder();
			for (int c = reader.read(), i = 0, k = 0;; c = reader.read(), ++i) {
				if (c == -1 || i >= MAX) {
					logger.info("notify after reading:" + i + " times:" + sbuf.toString());
					throw new IOException("weixin notify: messy");
				}
				sbuf.append((char) c); // bugfix-0: c cast to char!
				switch (c) {
				case '<':
					++k;
					if (k != 1) { // bugfix-1: test current k!
						k = 0;
					}
					break;
				case '/':
					++k;
					if (k != 2) {
						k = 0;
					}
					break;
				case 'x':
					++k;
					if (k != 3) {
						k = 0;
					}
					break;
				case 'm':
					++k;
					if (k != 4) {
						k = 0;
					}
					break;
				case 'l':
					++k;
					if (k != 5) {
						k = 0;
					}
					break;
				case '>':
					++k;
					if (k != 6) {
						k = 0;
					}
					break;
				default:
					k = 0;
				}
				if (k == xmlsz) {
					break;
				}
			}
			final String notify = sbuf.toString();
			sbuf = null;
			logger.info("返回参数内容readNotify-------------------->: " + notify);
			return notify;
		} finally {
			reader.close();
		}
	}*/
}

package web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminInfoDao;
import dao.CostDao;
import entity.AdminInfo;
import entity.Cost;
import util.ImageUtil;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res) 
					throws ServletException, IOException {
		String path = req.getServletPath();
		if("/findCost.do".equals(path)){
			findCost(req,res);
		}else if("/toaddCost.do".equals(path)){
			toaddCost(req,res);
		}else if("/addCost.do".equals(path)){
			addCost(req,res);
		}else if("/toupdateCost.do".equals(path)){
			toupdateCost(req,res);
		}else if("/updateCost.do".equals(path)){
			updateCost(req,res);
		}else if("/deleteCost.do".equals(path)){
			//todo
		}else if("/toLogin.do".equals(path)){
			toLogin(req,res);
		}else if("/login.do".equals(path)){
			login(req,res);
		}else if("/toIndex.do".equals(path)){
			toIndex(req,res);
		}else if("/createImg.do".equals(path)){
			createImg(req,res);
		}else {
			throw new RuntimeException("地址书写错误，找不到资源");
		}
	}
  
	public void findCost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		//查询所有的资费
		CostDao cd = new CostDao();
		List<Cost> costs = cd.findAll();
		//给requset绑定数据
		req.setAttribute("costs", costs);
		//将请求转发给jsp
		//当前：netctoss/findCost.do
		//目标：netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher("WEB-INF/cost/find.jsp").forward(req,res);
	}
	public void toaddCost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		//转发
		req.getRequestDispatcher("WEB-INF/cost/add.jsp").forward(req, res);
	}
	
	public void addCost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		//post请求的时候乱码问题
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("cost_name");
		String base_duration = req.getParameter("base_duration");
		String base_cost = req.getParameter("base_cost");
		String unit_cost = req.getParameter("unit_cost");
		String desc = req.getParameter("desc");
		String cost_type = req.getParameter("costType");
		Cost cost = new Cost();
		cost.setName(name);
		if(isNotNull(base_duration)){
		cost.setBaseDuration(Long.parseLong(base_duration));
		}
		if(isNotNull(base_cost)){
		  cost.setBaseCost(Double.parseDouble(base_cost));
		}
		if(isNotNull(unit_cost)){
		 cost.setUnitCose(Double.parseDouble(unit_cost));
		}
		cost.setCostType(cost_type);
		cost.setDescr(desc);
		
		/*Cost cost = new Cost();
		cost.setName("元旦套餐");
		cost.setBaseDuration(Long.parseLong("12"));
		cost.setBaseCost(Double.parseDouble("12.99"));
		cost.setUnitCose(Double.parseDouble("0.8"));
		cost.setCostType("1");
		cost.setDescr("就看手机按键旷达科技");*/
		CostDao cd = new CostDao();
		//插入数据
		cd.addCost(cost);
		//重订向回查询页面
		res.sendRedirect("findCost.do");
	}
	
	public void toupdateCost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		String id = req.getParameter("id");
		Cost cost = new Cost();
		CostDao cd = new CostDao();
		if(isNotNull(id)){
			cost=cd.queryCostById(Integer.parseInt(id));
		}
		//设定传入参数
		req.setAttribute("cost", cost);
		//转发
		req.getRequestDispatcher("WEB-INF/cost/modify.jsp").forward(req, res);
	}
	
	public void updateCost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		//post请求的时候乱码问题
				req.setCharacterEncoding("utf-8");
				String id = req.getParameter("costId");
				String name = req.getParameter("costName");
				String base_duration = req.getParameter("baseDuration");
				String base_cost = req.getParameter("baseCost");
				String unit_cost = req.getParameter("unitCost");
				String desc = req.getParameter("desc");
				String cost_type = req.getParameter("costType");
				Cost cost = new Cost();
				if(isNotNull(id)){
					cost.setCostId(Integer.parseInt(id));
				}
				cost.setName(name);
				if(isNotNull(base_duration)){
					cost.setBaseDuration(Long.parseLong(base_duration));
				}
				if(isNotNull(base_cost)){
					  cost.setBaseCost(Double.parseDouble(base_cost));
				}
				if(isNotNull(unit_cost)){
					 cost.setUnitCose(Double.parseDouble(unit_cost));
				}
				cost.setCostType(cost_type);
				cost.setDescr(desc);
				CostDao cd = new CostDao();
				//更新数据
				cd.updateCost(cost);
				//重订向回查询页面
				res.sendRedirect("findCost.do");
	}
	
	//转登录页面
	public void toLogin(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req,res);
	}
	
	//转主页
	public void toIndex(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		req.getRequestDispatcher("WEB-INF/main/index.jsp").forward(req,res);
	}
	
	public void login(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		   String adminCode = req.getParameter("adminCode");
		   String password = req.getParameter("password");
		   String imgcode  = req.getParameter("imgcode");
		   
		   //校验验证码
		   HttpSession session = req.getSession();
		   String code = (String) session.getAttribute("imgCode");
		   if(imgcode==null||!imgcode.equalsIgnoreCase(code)){
			   req.setAttribute("error", "验证码不正确！");
			   req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			   return;
		   }
		   AdminInfoDao aid = new AdminInfoDao();
		   AdminInfo ai = aid.queryAdminByName(adminCode);
		   if(ai!=null){
			   if(ai.getPassword().equals(password)){
				   //将账号密码存入cookie
				   Cookie userCookie = new Cookie("user",ai.getAdminCode());
				   /*Cookie pwdCookie = new Cookie("pwd",ai.getPassword());*/
				   //将cookie存入response，当服务器向浏览器响应时，
				   //服务器会自动向浏览器发送cookie,浏览器会保存
				   res.addCookie(userCookie);
				 /*  res.addCookie(pwdCookie);*/
				   
				   //将账号存入session
				  // HttpSession session = req.getSession();
				   session.setAttribute("user", ai.getAdminCode());
				   
				   //重定向到主页
				   res.sendRedirect("toIndex.do");
			   }else{
				   req.setAttribute("error", "密码错误！");
				   req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			   }
		   }else{
			   req.setAttribute("error", "账号错误！");
			   req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
		   }
		  
	}
	
	//生成验证码
	public void createImg(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		   //生成验证码以及图片
		Object[] objs = ImageUtil.createImage();
		HttpSession session = req.getSession();
		//保存验证码
		session.setAttribute("imgCode", objs[0]);
		//将图片发送给浏览器,设置输出文件的格式
		res.setContentType("image/png");
		//获取字节流,该流由服务器创建
		//其目标就是当前访问的浏览器
		OutputStream os = res.getOutputStream();
		BufferedImage img = (BufferedImage) objs[1];
		ImageIO.write(img, "png", os);
		os.close();
	}
	
	//判断字符串是否为空
	public boolean isNotNull(String str){
		if(str!=null&&str.length()>0){
			return true;
		}
		return false;
	}
}

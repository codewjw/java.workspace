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
			throw new RuntimeException("��ַ��д�����Ҳ�����Դ");
		}
	}
  
	public void findCost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		//��ѯ���е��ʷ�
		CostDao cd = new CostDao();
		List<Cost> costs = cd.findAll();
		//��requset������
		req.setAttribute("costs", costs);
		//������ת����jsp
		//��ǰ��netctoss/findCost.do
		//Ŀ�꣺netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher("WEB-INF/cost/find.jsp").forward(req,res);
	}
	public void toaddCost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		//ת��
		req.getRequestDispatcher("WEB-INF/cost/add.jsp").forward(req, res);
	}
	
	public void addCost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		//post�����ʱ����������
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
		cost.setName("Ԫ���ײ�");
		cost.setBaseDuration(Long.parseLong("12"));
		cost.setBaseCost(Double.parseDouble("12.99"));
		cost.setUnitCose(Double.parseDouble("0.8"));
		cost.setCostType("1");
		cost.setDescr("�Ϳ��ֻ���������Ƽ�");*/
		CostDao cd = new CostDao();
		//��������
		cd.addCost(cost);
		//�ض���ز�ѯҳ��
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
		//�趨�������
		req.setAttribute("cost", cost);
		//ת��
		req.getRequestDispatcher("WEB-INF/cost/modify.jsp").forward(req, res);
	}
	
	public void updateCost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		//post�����ʱ����������
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
				//��������
				cd.updateCost(cost);
				//�ض���ز�ѯҳ��
				res.sendRedirect("findCost.do");
	}
	
	//ת��¼ҳ��
	public void toLogin(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req,res);
	}
	
	//ת��ҳ
	public void toIndex(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		req.getRequestDispatcher("WEB-INF/main/index.jsp").forward(req,res);
	}
	
	public void login(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		   String adminCode = req.getParameter("adminCode");
		   String password = req.getParameter("password");
		   String imgcode  = req.getParameter("imgcode");
		   
		   //У����֤��
		   HttpSession session = req.getSession();
		   String code = (String) session.getAttribute("imgCode");
		   if(imgcode==null||!imgcode.equalsIgnoreCase(code)){
			   req.setAttribute("error", "��֤�벻��ȷ��");
			   req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			   return;
		   }
		   AdminInfoDao aid = new AdminInfoDao();
		   AdminInfo ai = aid.queryAdminByName(adminCode);
		   if(ai!=null){
			   if(ai.getPassword().equals(password)){
				   //���˺��������cookie
				   Cookie userCookie = new Cookie("user",ai.getAdminCode());
				   /*Cookie pwdCookie = new Cookie("pwd",ai.getPassword());*/
				   //��cookie����response�������������������Ӧʱ��
				   //���������Զ������������cookie,������ᱣ��
				   res.addCookie(userCookie);
				 /*  res.addCookie(pwdCookie);*/
				   
				   //���˺Ŵ���session
				  // HttpSession session = req.getSession();
				   session.setAttribute("user", ai.getAdminCode());
				   
				   //�ض�����ҳ
				   res.sendRedirect("toIndex.do");
			   }else{
				   req.setAttribute("error", "�������");
				   req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			   }
		   }else{
			   req.setAttribute("error", "�˺Ŵ���");
			   req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
		   }
		  
	}
	
	//������֤��
	public void createImg(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		   //������֤���Լ�ͼƬ
		Object[] objs = ImageUtil.createImage();
		HttpSession session = req.getSession();
		//������֤��
		session.setAttribute("imgCode", objs[0]);
		//��ͼƬ���͸������,��������ļ��ĸ�ʽ
		res.setContentType("image/png");
		//��ȡ�ֽ���,�����ɷ���������
		//��Ŀ����ǵ�ǰ���ʵ������
		OutputStream os = res.getOutputStream();
		BufferedImage img = (BufferedImage) objs[1];
		ImageIO.write(img, "png", os);
		os.close();
	}
	
	//�ж��ַ����Ƿ�Ϊ��
	public boolean isNotNull(String str){
		if(str!=null&&str.length()>0){
			return true;
		}
		return false;
	}
}

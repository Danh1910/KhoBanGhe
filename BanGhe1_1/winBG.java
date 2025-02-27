package BanGhe1_1;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.PageAttributes.OriginType;

import javax.swing.JPasswordField;

public class winBG {

	private JFrame frame;
	static public ArrayList<BanGhe> A1; 
	static public ArrayList<User> userList;
	static public int SL;
	private JTextField PrName_text;
	private JTextField NoiSX_text;
	private JTextField ChatLieu_text;
	private JTextField KichThuoc_test;
	DefaultTableModel model;
	DefaultTableModel model1;
	DefaultTableModel model2;
	DefaultTableModel model3;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField Sluong_text;
	private JTextField PrID_text;
	private JTextField MaPhieu;
	private JTextField Ngay;
	private JTextField Maban;
	private JTextField SoluongB;
	private JTextField Username_text;
	private JPasswordField passwordField;
	static private DataSQL sql;
	private JTable table_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public void LuuList() {
		
	}
	public String Phuongthuckhoitaomatkhautheophuongthucthemkhoangtrongphanduoi(String t) {
		String h = t;
		for (int i = 0;i < 16-t.length();i++) {
			h += ' ';
		}
		return h;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sql = new DataSQL();
					A1 = sql.getListBanGhe();
					userList = sql.getListUser();
					for (int i = 0;i < userList.size();i++) {
						userList.get(i).inTT();
					}
					winBG window = new winBG();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public winBG() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame("Quản Lý Kho Bàn Ghế");
		frame.setBounds(100, 100, 768, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(126, 162, 190));
		frame.getContentPane().setLayout(null);
		
		/////PHẦN DÀNH CHO CÁC BẢNG
		model = new DefaultTableModel();
		model1 = new DefaultTableModel();
		model2 = new DefaultTableModel();
		model3 = new DefaultTableModel();
		
		Object[] column = {"ID","Tên SP","Chất liệu", "Số lượng","Nơi SX","Kích thước"}; 
		Object[] column1 = {"Mã Bàn Ghế","Số Lượng"};
		Object[] column2 = {"Mã Phiếu", "Ngày", "Người Nhập", "Số Bàn Ghế", "Danh Sách"};
		Object[] column3 = {"ID" , "Tên Đăng Nhập", "Password"};
 		
		Object[] row = new Object[6];
		Object[] row1 = new Object[2];
		Object[] row2 = new Object[5];
		Object[] row3 = new Object[3];

		model.setColumnIdentifiers(column);
		model1.setColumnIdentifiers(column1);
		model2.setColumnIdentifiers(column2);
		model3.setColumnIdentifiers(column3);
		//////////////////////
		
		if (A1 != null) {
			for (int i = 0; i < A1.size();i++) {
				row[0] = A1.get(i).getMaBG();
				row[1] = A1.get(i).getTensp();
				row[2] = A1.get(i).getChatLieu();
				row[3] = A1.get(i).getSoLuong();
				row[4] = A1.get(i).getNoiSX();
				row[5] = A1.get(i).getKichThuoc();
				model.addRow(row);
			}
		}
		if (userList != null) {
			for (int i = 0;i < userList.size();i++) {
				row3[0] = userList.get(i).getID();
				row3[1] = userList.get(i).getUsername();
				row3[2] = userList.get(i).getPassword();
				model3.addRow(row3);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 100, 128));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 100, 128));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 100, 128));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(64, 100, 128));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(126, 162, 190));
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		panel_4.setVisible(false);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(209, 131, 252));
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		panel_6.setVisible(false);
		

		panel.setBounds(166, 400, 600, 448);
		panel_1.setBounds(166, 400, 600, 448);
		panel_2.setBounds(166, 400, 600, 448);
		panel_3.setBounds(166, 400, 600, 448);
		panel_4.setBounds(0, 400, 165, 302);
		panel_5.setBounds(0, 400, 752, 389);
		panel_6.setBounds(0, 400, 752, 389);
		
		panel.setBounds(166, 0, 600, 448); // Danh sách sản phẩm 
		panel_1.setBounds(166, 0, 600, 448); // 
		panel_2.setBounds(166, 0, 600, 448);
		panel_3.setBounds(166, 0, 600, 448);   //Phiếu nhập
		panel_4.setBounds(0, 0, 165, 302); //
		panel_5.setBounds(0, 0, 752, 389);   // phần đăng nhập
		panel_6.setBounds(0, 0, 752, 389); // admin
		
		JLabel lblNewLabel_1 = new JLabel("Mã Phiếu");
		lblNewLabel_1.setBounds(10, 11, 82, 17);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày ");
		lblNewLabel_1_4.setBounds(10, 33, 82, 17);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Mã Bàn ghế");
		lblNewLabel_1_5.setBounds(233, 9, 82, 17);
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Số lượng");
		lblNewLabel_1_6.setBounds(233, 33, 82, 17);
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 135, 566, 230);
		panel_3.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 569, 361);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(model2);
		
		table_1 = new JTable();
		table_1.setModel(model1);
		
		table_3 = new JTable();
		table_3.setModel(model3);
		table_3.setBackground(new Color(233, 194, 254));
		
		
		MaPhieu = new JTextField();
		MaPhieu.setBounds(94, 11, 86, 20);
		panel_3.add(MaPhieu);
		MaPhieu.setColumns(10);
		
		Ngay = new JTextField();
		Ngay.setBounds(94, 33, 86, 20);
		Ngay.setColumns(10);
		panel_3.add(Ngay);
		
		Maban = new JTextField();
		Maban.setBounds(317, 9, 86, 20);
		Maban.setColumns(10);
		panel_3.add(Maban);
		
		SoluongB = new JTextField();
		SoluongB.setBounds(317, 30, 86, 20);
		SoluongB.setColumns(10);
		panel_3.add(SoluongB);
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setBounds(415, 10, 89, 20);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean trung = false; // kiểm tra trùng 
				if (!Maban.getText().equals("")) { // nếu như mã nhập có ký tự 
					for (int i = 0;i < A1.size();i++) {
						if (Maban.getText().equals(A1.get(i).getMaBG())) { 
							trung = true; // tức là có tồn tại mã vừa nhập trong danh sách sản phẩm 
							break;
						}
					}	
				}
				if (trung) { // lấy giá trị từ đoạn trên 
					if (Maban.getText().equals("") || SoluongB.getText().equals("") || MaPhieu.getText().equals("") || Ngay.getText().equals("")) // kiểm tra các thông tin đã điền có đầy đủ ko
					{
						JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin! ! ! ! !"); 
					} else {
						row1[0] = Maban.getText();
						row1[1] = SoluongB.getText();
						model1.addRow(row1);
					
						Maban.setText("");
						SoluongB.setText("");
						JOptionPane.showMessageDialog(null, "Thêm Thành Công");
					}		
				}else { // nhận không có sản phẩm trong DS hoặc chưa điền
					if (Maban.getText().equals("")) // nhận trường hợp chưa điền mã
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã cho sản phẩm!");
					else  // nhận trường hợp có mã 
						JOptionPane.showMessageDialog(null, "Mã vừa nhập không tồn tại"); 
				}
			}
		});
		panel_3.add(btnNewButton_2);
		panel_3.setVisible(false);
		
		
		
		JButton btnNewButton_1 = new JButton("Cập Nhật");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean trung = false; 
				int vitri = -1;
				if (!PrID_text.getText().equals("")) { 
					for (int i = 0;i < A1.size();i++) {
						if (PrID_text.getText().equals(A1.get(i).getMaBG())) { 
							trung = true; 
							vitri = i;
							break;
						}
					}	
				}
				if (trung) { 
					model.setValueAt(PrID_text.getText(), vitri, 0);
					model.setValueAt(PrName_text.getText(), vitri, 1);
					model.setValueAt(ChatLieu_text.getText(), vitri, 2);
					model.setValueAt(Sluong_text.getText(), vitri, 3);
					model.setValueAt(NoiSX_text.getText(), vitri, 4);
					model.setValueAt(KichThuoc_test.getText(), vitri, 5);
					
					
					A1.get(vitri).setMaBG(PrID_text.getText());
					A1.get(vitri).setTensp( PrName_text.getText());
					A1.get(vitri).setChatLieu(ChatLieu_text.getText());
					A1.get(vitri).setSoLuong( Integer.parseInt(Sluong_text.getText()));
					A1.get(vitri).setNoiSX(NoiSX_text.getText());
					A1.get(vitri).setKichThuoc( KichThuoc_test.getText());
					
					sql.UpdateBanGhe(A1.get(vitri));
				
					PrID_text.setText("");
					PrName_text.setText("");
					ChatLieu_text.setText("");
					NoiSX_text.setText("");
					Sluong_text.setText("");
					KichThuoc_test.setText("");
					JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");		
				}else { 
					if (PrID_text.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã cho sản phẩm!");
					else  
						JOptionPane.showMessageDialog(null, "Mã vừa nhập không tồn tại"); 
				}
			}
		});
		btnNewButton_1.setBounds(298, 45, 89, 23);
		panel.add(btnNewButton_1);
		//frame.getContentPane().remove(panel);
		
		JButton btnNewButton = new JButton("Thêm SP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean trung = false;
				if (!PrID_text.getText().equals("")) {
					for (int i = 0;i < A1.size();i++) {
						if (PrID_text.getText().equals(A1.get(i).getMaBG())) {
							trung = true;
							JOptionPane.showMessageDialog(null, "Mã Sản Phẩm bị trùng với " + A1.get(1).getTensp() + "!");
							break;
						}
					}	
				}
				if (trung == false) {
					if (PrID_text.getText().equals("") || PrName_text.getText().equals("") || ChatLieu_text.getText().equals("") || NoiSX_text.getText().equals("") || Sluong_text.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin! ! ! ! !");
					} else {
						row[0] = PrID_text.getText();
						row[1] = PrName_text.getText();
						row[2] = ChatLieu_text.getText();
						row[3] = Sluong_text.getText();
						row[4] = NoiSX_text.getText();
						row[5] = KichThuoc_test.getText();
						model.addRow(row);
						
						BanGhe t = new BanGhe();
						t.setMaBG(PrID_text.getText());
						t.setTensp( PrName_text.getText());
						t.setChatLieu(ChatLieu_text.getText());
						t.setSoLuong( Integer.parseInt(Sluong_text.getText()));
						t.setNoiSX(NoiSX_text.getText());
						t.setKichThuoc( KichThuoc_test.getText());
						sql.addBanGhe(t);
						A1.add(t);
					
						PrID_text.setText("");
						PrName_text.setText("");
						ChatLieu_text.setText("");
						NoiSX_text.setText("");
						Sluong_text.setText("");
						KichThuoc_test.setText("");
						JOptionPane.showMessageDialog(null, "Thêm Thành Công");
					}		
				}
			}
		});
		btnNewButton.setBounds(298, 11, 89, 23);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				PrID_text.setText(model.getValueAt(i, 0).toString());
				PrName_text.setText(model.getValueAt(i, 1).toString());
				ChatLieu_text.setText(model.getValueAt(i, 2).toString());
				Sluong_text.setText(model.getValueAt(i, 3).toString());
				NoiSX_text.setText(model.getValueAt(i, 4).toString());
				KichThuoc_test.setText(model.getValueAt(i, 5).toString());
			}
		});
		table.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 563, 204);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(194, 11, 548, 355);
		panel_6.add(scrollPane_3);
		
		

		//scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		scrollPane_1.setViewportView(table_1);
		scrollPane_2.setViewportView(table_2);
		scrollPane_3.setViewportView(table_3);
		
		JButton btnNewButton_4 = new JButton("Thêm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(10, 187, 142, 23);
		panel_6.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Sửa");
		btnNewButton_4_1.setBounds(10, 221, 142, 23);
		panel_6.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_1_1 = new JButton("Xóa");
		btnNewButton_4_1_1.setBounds(10, 255, 142, 23);
		panel_6.add(btnNewButton_4_1_1);
		
		JButton btnNewButton_4_1_2 = new JButton("Khóa đăng nhập");
		btnNewButton_4_1_2.setBounds(10, 288, 142, 23);
		panel_6.add(btnNewButton_4_1_2);
		
		JButton btnNewButton_4_1_3 = new JButton("Đăng Xuất");
		btnNewButton_4_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_5.setVisible(true);
				panel_6.setVisible(false);
			}
		});
		btnNewButton_4_1_3.setBounds(10, 322, 142, 23);
		panel_6.add(btnNewButton_4_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 12, 75, 23);
		panel_6.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(10, 32, 154, 20);
		panel_6.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Username");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(10, 57, 75, 23);
		panel_6.add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 77, 154, 20);
		panel_6.add(textField_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Password");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(10, 102, 75, 23);
		panel_6.add(lblNewLabel_3_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 122, 154, 20);
		panel_6.add(textField_2);
		
		
		JButton btnNewButton_2_1 = new JButton("Lưu");
		btnNewButton_2_1.setBounds(94, 63, 86, 40);
		panel_3.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Xóa");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_2.setBounds(415, 42, 89, 20);
		panel_3.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Sửa");
		btnNewButton_2_3.setBounds(415, 73, 89, 20);
		panel_3.add(btnNewButton_2_3);
		
		JButton btnNewButton_1_1 = new JButton("Xóa SP");
		btnNewButton_1_1.setBounds(422, 45, 89, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Tim kiếm");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PrID_text.getText().equals("") && PrName_text.getText().equals("") && ChatLieu_text.getText().equals("") 
						&& NoiSX_text.getText().equals("") && Sluong_text.getText().equals("")  && KichThuoc_test.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Nhập Thông tin bất kì để tìm kiếm");
					if (model.getRowCount() < A1.size()) {
						int contRow = model.getRowCount();
						for (int i =0 ;i < contRow;i++) {
							model.removeRow(0);
						}
						for (int i = 0;i < A1.size();i++) {
							row[0] = A1.get(i).getMaBG();
							row[1] = A1.get(i).getTensp();
							row[2] = A1.get(i).getChatLieu();
							row[3] = A1.get(i).getSoLuong();
							row[4] = A1.get(i).getNoiSX();
							row[5] = A1.get(i).getKichThuoc();
							model.addRow(row);
						}
					}
				} else {
					int contRow = model.getRowCount();
					for (int i =0 ;i < contRow;i++) {
						model.removeRow(0);
					}
				}
				if (!PrID_text.getText().equals("")) {
					for (int i = 0;i < A1.size();i++) {
						if (PrID_text.getText().equals(A1.get(i).getMaBG())) {
							row[0] = A1.get(i).getMaBG();
							row[1] = A1.get(i).getTensp();
							row[2] = A1.get(i).getChatLieu();
							row[3] = A1.get(i).getSoLuong();
							row[4] = A1.get(i).getNoiSX();
							row[5] = A1.get(i).getKichThuoc();
							model.addRow(row);
						}
					}
				} else {
					boolean timThay = false;
					for (int i = 0;i < A1.size();i++) {
						timThay = false;
						if (!PrName_text.getText().equals("")) 
							if (PrName_text.getText().equalsIgnoreCase(A1.get(i).getTensp())) 
								timThay = true;
						if (!ChatLieu_text.getText().equals("")) {
							if (ChatLieu_text.getText().equalsIgnoreCase(A1.get(i).getChatLieu()))
								timThay = true;
							else 
								timThay = false;
						}
						if (!NoiSX_text.getText().equals("")) {
							if (NoiSX_text.getText().equalsIgnoreCase(A1.get(i).getNoiSX()))
								timThay = true;
							else 
								timThay = false;
						}
						if (!Sluong_text.getText().equals("")) {
							if (Integer.parseInt(Sluong_text.getText()) == A1.get(i).getSoLuong())
								timThay = true;
							else 
								timThay = false;
						}
						if (!KichThuoc_test.getText().equals("")) {
							if (KichThuoc_test.getText().equalsIgnoreCase(A1.get(i).getKichThuoc()))
								timThay = true;
							else 
								timThay = false;
						}
						if (timThay) {
							row[0] = A1.get(i).getMaBG();
							row[1] = A1.get(i).getTensp();
							row[2] = A1.get(i).getChatLieu();
							row[3] = A1.get(i).getSoLuong();
							row[4] = A1.get(i).getNoiSX();
							row[5] = A1.get(i).getKichThuoc();
							model.addRow(row);
						}
					}
				}
			}
		});
		btnNewButton_1_2.setBounds(422, 11, 89, 23);
		panel.add(btnNewButton_1_2);
		
		Sluong_text = new JTextField();//số lượng
		Sluong_text.setBounds(94, 136, 134, 20);
		panel.add(Sluong_text);
		Sluong_text.setColumns(10);
		
		JLabel Sluong = new JLabel("Số Lượng");
		Sluong.setBounds(10, 142, 90, 14);
		panel.add(Sluong);
		Sluong.setForeground(Color.WHITE);
		
		JLabel KichThuoc = new JLabel("Kích thước");
		KichThuoc.setBounds(10, 117, 90, 14);
		panel.add(KichThuoc);
		KichThuoc.setForeground(new Color(255, 255, 255));
		
		KichThuoc_test = new JTextField();//Hình Dạng
		KichThuoc_test.setBounds(94, 111, 134, 20);
		panel.add(KichThuoc_test);
		KichThuoc_test.setColumns(10);
		
		ChatLieu_text = new JTextField();  //chất liệu
		ChatLieu_text.setBounds(94, 86, 134, 20);
		panel.add(ChatLieu_text);
		ChatLieu_text.setColumns(10);
		
		JLabel ChatLieu = new JLabel("Chất liệu");
		ChatLieu.setBounds(10, 92, 90, 14);
		panel.add(ChatLieu);
		ChatLieu.setForeground(new Color(255, 255, 255));
		
		JLabel NoiSX = new JLabel("Nơi SX");
		NoiSX.setBounds(10, 67, 90, 14);
		panel.add(NoiSX);
		NoiSX.setForeground(new Color(255, 255, 255));
		
		NoiSX_text = new JTextField(); // nguồn Gốc
		NoiSX_text.setBounds(94, 61, 134, 20);
		panel.add(NoiSX_text);
		NoiSX_text.setColumns(10);
		
		JLabel PrName = new JLabel("Tên Sản phẩm");
		PrName.setBounds(10, 39, 90, 14);
		panel.add(PrName);
		PrName.setForeground(new Color(255, 255, 255));
		
		PrName_text = new JTextField();
		PrName_text.setBounds(94, 36, 134, 20);
		panel.add(PrName_text);
		PrName_text.setColumns(10);
		
		PrID_text = new JTextField(); //ID
		PrID_text.setBounds(94, 11, 134, 20);
		panel.add(PrID_text);
		PrID_text.setColumns(10);
		
		
		JLabel PrID = new JLabel("ID");
		PrID.setBounds(10, 14, 90, 14);
		panel.add(PrID);
		PrID.setForeground(Color.WHITE);
		
		
		
		
		JButton btnNewButton_2_1_1_2 = new JButton("Danh Sách");
		btnNewButton_2_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
			}
		});
		btnNewButton_2_1_1_2.setBounds(8, 5, 141, 23);
		panel_4.add(btnNewButton_2_1_1_2);
		
		JButton btnNewButton_2_1_1_1_1_1_2 = new JButton("Nhập Kho");
		btnNewButton_2_1_1_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		btnNewButton_2_1_1_1_1_1_2.setBounds(8, 33, 141, 23);
		panel_4.add(btnNewButton_2_1_1_1_1_1_2);
		
		JButton btnNewButton_2_1_1_1_1_1_2_1 = new JButton("Xuất Kho");
		btnNewButton_2_1_1_1_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1_1_1_1_1_2_1.setBounds(8, 61, 141, 23);
		panel_4.add(btnNewButton_2_1_1_1_1_1_2_1);
		
		JButton btnNewButton_2_1_1_1_1_1_1_1 = new JButton("Danh Sách Phiếu Nhập");
		btnNewButton_2_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
				panel_4.setVisible(true);
				panel_5.setVisible(false);
			}
		});
		btnNewButton_2_1_1_1_1_1_1_1.setBounds(8, 88, 141, 23);
		panel_4.add(btnNewButton_2_1_1_1_1_1_1_1);
		
		JButton btnNewButton_2_1_1_1_1_1_1_1_2 = new JButton("Danh Sách Phiếu Xuất");
		btnNewButton_2_1_1_1_1_1_1_1_2.setBounds(8, 115, 141, 23);
		panel_4.add(btnNewButton_2_1_1_1_1_1_1_1_2);
		
		
		JButton btnNewButton_2_1_1_1_1_1_1_1_1 = new JButton("Đăng Xuất");
		btnNewButton_2_1_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(true);
				
			}
		});
		btnNewButton_2_1_1_1_1_1_1_1_1.setBounds(8, 143, 141, 23);
		panel_4.add(btnNewButton_2_1_1_1_1_1_1_1_1);
		
		
		
		
		
		
		JButton btnNewButton_3 = new JButton("Đăng Nhập");
		btnNewButton_3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				boolean trung = false;
				int vitri = 0;
				if (!Username_text.getText().equals("")) {
					for (int i = 0;i < userList.size();i++) {
						if (Username_text.getText().equals(userList.get(i).getUsername())) {
							trung = true;
							vitri = i;
						}
					}
				}
				if (trung) {
					String mk = Phuongthuckhoitaomatkhautheophuongthucthemkhoangtrongphanduoi(passwordField.getText());
					if ( !mk.equals(userList.get(vitri).getPassword())) {
						JOptionPane.showMessageDialog(null, "Mật Khẩu không đúng");
						System.out.println(mk + "|");
						passwordField.setText("");
					}
					else if (userList.get(vitri).getID().equals("NNB002")) {
						panel_6.setVisible(true);
						panel_5.setVisible(false);
						Username_text.setText("");
						passwordField.setText("");
					}
					else {
						panel.setVisible(true);
						panel_1.setVisible(false);
						panel_2.setVisible(false);
						panel_3.setVisible(false);
						panel_4.setVisible(true);
						panel_5.setVisible(false);
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công tài khoản " + userList.get(vitri).getUsername() );
						Username_text.setText("");
						passwordField.setText("");
					}
					
				} else 
					JOptionPane.showMessageDialog(null, "Thông tin đã điền chưa đúng");
				if (userList == null) {
					panel.setVisible(true);
					panel_1.setVisible(false);
					panel_2.setVisible(false);
					panel_3.setVisible(false);
					panel_4.setVisible(true);
					panel_5.setVisible(false);
					JOptionPane.showMessageDialog(null, "Đăng Nhập Mới ");
					Username_text.setText("");
					passwordField.setText("");
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(289, 258, 153, 41);
		panel_5.add(btnNewButton_3);
		
		Username_text = new JTextField();
		Username_text.setBounds(289, 85, 153, 30);
		panel_5.add(Username_text);
		Username_text.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(208, 85, 71, 30);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(208, 126, 71, 30);
		panel_5.add(lblNewLabel_2);
		
		passwordField = new JPasswordField(16);
		passwordField.setBounds(289, 126, 153, 30);
		panel_5.add(passwordField);
		
		
		
		
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.removeRow(i);
					A1 = sql.XoaSanPham(A1, i);
					JOptionPane.showMessageDialog(null, "Xóa Thành Công");
					
				} else {
					JOptionPane.showMessageDialog(null, "Hãy Chọn 1 Hàng Để Xóa");
				}
			}
		});
		
	}
}

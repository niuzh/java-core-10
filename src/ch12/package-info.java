/**
 * Swing用户界面组件：介绍了构造功能更加齐全的图形用户界面的工具。
 * 	知识点记忆：想象一个Swing界面是由模型-视图-控制器三部分组成，窗口有一个简单的布局管理器，窗口下方有文本组件，上面是选择选择组件，顶部是菜单组件，
 * 	现在组件太多了，需要考虑复杂的布局管理器，弹出一个对话框确认，程序完毕后，进行GUI程序的排错。
 * 
 * Swing与模型-视图-控制器设计模式：首先介绍设计模式概念，然后讲解了MVC模式，最后通过Swing按钮案例落地。
 * 	设计模式：特定的背景下，使用特殊方案解决特定的需求的模式。
 * 	模型(存储内容)-视图(显示内容)-控制器模式(处理用户输入)
 * 	Swing按钮的模型-视图-控制器分析：通过JButton介绍MVC模式。
 * 布局管理概述：介绍了Swing的类层级结构以及容器，组件。
 * 	边框布局
 * 	网格布局
 * 文本输入
 * 	文本域(JTextField)
 * 	标签和标签组件(JLable)
 * 	密码域(JPasswordField)
 * 	文本区(JTextArea)
 * 	滚动窗格(JScrollPanel)
 * 选择组件
 * 	复选框(JCheckBox)
 * 	单选纽(ButtonGroup、JRadioButton)
 * 	边框
 * 	组合框(JComboBox)
 * 	滑动条(JSlider)
 * 菜单
 * 	创建菜单(JMenuBar,JMenu,JMenuItem)
 * 	菜单项中的图标
 * 	复选框和单选按钮菜单(JCheckBoxHenuItem RadioButtonMenuItem)
 * 	弹出菜单(JPopupMenu)
 * 	快捷键和加速器：可以同时按下 ALT 键和菜单的快捷键来实现在菜单栏中选择一个顶层菜单的操作 。
 * 	启用和禁用菜单项
 * 	工具栏(JToolBar)
 * 	工具提示
 * 复杂的布局管理
 * 	网格组布局：GridBagLayout，
 * 	组布局
 * 	不使用布局管理器
 * 	定制布局管理器
 * 	遍历顺序：遍历顺序很直观, 它的顺序是从左至右 , 从上至下 。
 * 对话框：介绍了对话框和与对话框交流数据
 * 	选项对话框(JOptionPane)
 * 	创建对话框
 * 	数据交换
 * 	文件对话框(JFileChooser)
 * 	颜色选择器(JColorChooser)
 * GUI程序排错
 * 	调试技巧
 * 	让AWT机器人完成工作：Robot 类可以向任何 AWT 程序发送按键和鼠标点击事件 。
 * @author niuzhihuan
 */
package ch12;
package QQ.QQClient.qqclient.view;

import QQ.QQClient.qqclient.service.UserClientService;
import QQ.QQClient.qqclient.utils.Utility;

public class QQView {
    private boolean loop = true;
    private String key = "";
    private UserClientService userClientService = new UserClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
    }

    private void mainMenu()
    {
        while(loop)
        {
            System.out.println("==========欢迎登录网络通信系统==========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择: ");
            key = Utility.readString(1);
            switch(key)
            {
                case "1":
                    System.out.print("请输入用户号: ");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密 码: ");
                    String pwd = Utility.readString(50);
                    if(userClientService.checkUser(userId,pwd))
                    {
                        System.out.println("==========欢迎 (用户 " + userId + " ) ==========");
                        while(loop)
                        {
                            System.out.println("\n==========网络通信系统二级菜单(用户 " + userId + " )==========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择: ");
                            key = Utility.readString(1);
                            switch (key)
                            {
                                case "1":

                                    break;
                                case "2":
                                    break;
                                case "3":
                                    break;
                                case "4":
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("==========登录失败==========");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }
}

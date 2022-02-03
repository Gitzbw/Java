package QQ.QQClient.qqclient.view;

import QQ.QQClient.qqclient.service.FileClientService;
import QQ.QQClient.qqclient.service.MessageClientService;
import QQ.QQClient.qqclient.service.UserClientService;
import QQ.QQClient.qqclient.utils.Utility;

public class QQView {
    private boolean loop = true;
    private String key = "";
    private UserClientService userClientService = new UserClientService();
    private MessageClientService  messageClientService = new MessageClientService();
    private FileClientService fileClientService = new FileClientService();


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
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("请输入群发内容: ");
                                    String s = Utility.readString(100);
                                    messageClientService.sendMessageToAll(s,userId);
                                    break;
                                case "3":
                                    System.out.print("请输入想私聊的用户: ");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入内容: ");
                                    String content = Utility.readString(100);
                                    messageClientService.sendMessageToOne(content,userId,getterId);
                                    break;
                                case "4":
                                    System.out.print("请输入你想发送文件的用户: ");
                                    getterId = Utility.readString(50);
                                    System.out.print("请输入所发送文件的路径(如:d:\\xx.jpg): ");
                                    String src = Utility.readString(100);
                                    System.out.print("请输入把文件发送到的对应路径(如:d:\\yy.jpg): ");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFileToOne(src,dest,userId,getterId);
                                    break;
                                case "9":
                                    userClientService.logOut();
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

# 作业提交流程

1. 注册github账号（假设账户名称为applover。若已注册则跳过此步骤）；
2. 用此账号登陆github（若已登陆则跳过此步骤）；
3. fork本仓库（ https://github.com/njuics/app-2017f-homework ）至自己账户，仓库名称为applover/app-2017f-homework, url为（ https://github.com/javalover/app-2017f-homework );
4. 在你的本机clone你所fork的仓库(applover/app-2017f-homework）；
5. 在applover账户下新建一个代码仓库，例如myhomework；
6. 在myhomework下编写代码，代码使用`git add .`, `git commit -a` 和`git push`等命令进行管理；
7. 在applover/app-2017f-homework进入当前作业目录，例如app-2017f-homework／20170911目录，执行`git submodule add https://github.com/applover/myhomework 张三-141220001`,此处“张三”和“141220001” 分别替换真实姓名和学号。
8. 在applover/app-2017f-homework上创建“pull request"

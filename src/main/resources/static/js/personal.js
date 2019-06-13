axios.defaults.withCredentials = true
function validatePhone(str) {
    const reg = /^1[3|4|5|7|8][0-9]\d{8}$/
    console.log(reg.test(str))
    return reg.test(str)
}
var validPhone=(rule, value,callback)=> {
    if (!value) {
        callback(new Error('请输入电话号码'))
    } else if (!validatePhone(value)) {
        callback(new Error('请输入正确的11位手机号码'))
    } else {
        callback()
    }
}
    new Vue({
    el: "#personal-container",
    data: function () {
        return {
            userName: userName,
            userId: userId,
            headUrl: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
            activeIndex: "1",
            activeIndex2: "1",
            activeName: "1",
            man: "男",
            woman: "女",
            form: {
                userName: userName,
                gender: "男",
                birth: new Date("2019-06-12"),
                phone: "12345678911"
            },
            rules: {
                userName: [
                    {required: true, message: "请输入用户名", trigger: "blur"},
                    {min:2, max: 10, message: "长度在3到10个字符之间", trigger: "blur"}
                ],
                gender: [{required: true, message: "请选择性别", trigger: "blur"}],
                birth: [{required: true, type: "date", message: "请选择生日", trigger: "blur"}],
                phone: [{required: true, validator:validPhone ,trigger:"blur"}]
            },
            imageUrl: "",
            dialogVisible: false,
            courses: [{
                courseId: "1001",
                courseName: "java实现权限管理（下）",
                selectNumber: 54,
                teacher: "moocer",
                content: "简介：Java权限管理系列课程介绍如何使用SpringMVC+Spring来实现基于RBAC的权限管理系统。本套系列课程包括两门课程，本课程是第二门课，主要介绍权限管理系统控制层实现及优化。",
                url: "http://localhost:8080/static/image/java_1_1.jpg",
                link: "http://localhost:8080/studycenter/index?courseId=1001",
                progress: "第一章"
            }, {
                courseId: "1002",
                courseName: "C++远征之模板篇",
                selectNumber: 32,
                teacher: "james_yuan",
                content: "简介：本课程将带领大家体会更为奇妙的C++，讲述了静态、友元、运算符重载的定义及使用方法，其中重点讲述函数模板、类模板以及标准模板库的相关知识，知识内容更重实用性，本门课程对于面向对象的语言的学习将大有裨益，所有知识均以实践的方式讲解到操作层面，力求即学即会。",
                url: "http://localhost:8080/static/image/course_c++_1.jpg",
                link: "http://localhost:8080/studycenter/index?courseId=1002",
                progress: "第二章"
            }, {
                courseId: "",
                courseName: "java实现权限管理（上）",
                selectNumber: 54,
                teacher: "moccer",
                content: "简介：Java权限管理系列课程介绍如何使用SpringMVC+Spring来实现基于RBAC的权限管理系统。本套系列课程包括两门课程，本课程是第一门课，主要介绍什么是基于角色的访问控制（RBAC），以及数据访问层和服务层的实现。",
                url: "http://localhost:8080/static/image/java_1_2.jpg",
                link: "https://www.baidu.com",
                progress: "第一章"
            }, {
                courseId: "",
                courseName: "C++远征之多态篇",
                selectNumber: 32,
                teacher: "james_yuan",
                content: "简介：本课程将带领大家体会面向对象三大特性中的多态特性，讲述了虚函数、抽象类和接口类等概念，以及多态的实现原理，课程的最后引入RTTI及异常处理，使整个多态篇更加完整，更具实战指导性，本门课程是C++远征课程的高潮和经典，对于面向对象的语言的学习将大有裨益。",
                url: "http://localhost:8080/static/image/course_c++_2.jpg",
                link: "https://www.baidu.com",
                progress: "第二章"
            }, {
                courseId: "",
                courseName: "C++远征之继承篇",
                selectNumber: 54,
                teacher: "james_yuan",
                content: "简介：本课程将带领大家体会C++面向对象三大特性中的继承特性，讲述了基类、派生类的概念，公有继承、保护继承和私有继承、多重继承及多继承，虚析构函数及虚继承的作用，理解课程内容对于面向对象的学习将大有裨益，所有知识均通过编码实践的方式讲解到操作层面，力求即学即会。",
                url: "http://localhost:8080/static/image/course_c++_3.jpg",
                link: "https://www.baidu.com",
                progress: "第一章"
            }, {
                courseId: "",
                courseName: "C++远征之起航篇",
                selectNumber: 32,
                teacher: "james_yuan",
                content: "简介：本教程是C++的初级教程，是在C语言基础上的一个延伸，讲述了包括新增数据类型、命名空间等内容，最后通过一个通俗易懂的例子将所述知识点融会贯通，以达到知识灵活运用，最终得以升华的目的。",
                url: "http://localhost:8080/static/image/course_c++_4.jpg",
                link: "https://www.baidu.com",
                progress: "第二章"
            }, {
                courseId: "001",
                courseName: "java实现权限管理（下）",
                selectNumber: 54,
                teacher: "moocer",
                content: "简介：Java权限管理系列课程介绍如何使用SpringMVC+Spring来实现基于RBAC的权限管理系统。本套系列课程包括两门课程，本课程是第二门课，主要介绍权限管理系统控制层实现及优化。",
                url: "http://localhost:8080/static/image/java_1_1.jpg",
                link: "http://localhost:8080/studycenter/index?userId=001",
                progress: "第一章"
            }, {
                courseId: "",
                courseName: "C++远征之模板篇",
                selectNumber: 32,
                teacher: "james_yuan",
                content: "简介：本课程将带领大家体会更为奇妙的C++，讲述了静态、友元、运算符重载的定义及使用方法，其中重点讲述函数模板、类模板以及标准模板库的相关知识，知识内容更重实用性，本门课程对于面向对象的语言的学习将大有裨益，所有知识均以实践的方式讲解到操作层面，力求即学即会。",
                url: "http://localhost:8080/static/image/course_c++_1.jpg",
                link: "https://www.baidu.com",
                progress: "第二章"
            }, {
                courseId: "",
                courseName: "java实现权限管理（上）",
                selectNumber: 54,
                teacher: "moccer",
                content: "简介：Java权限管理系列课程介绍如何使用SpringMVC+Spring来实现基于RBAC的权限管理系统。本套系列课程包括两门课程，本课程是第一门课，主要介绍什么是基于角色的访问控制（RBAC），以及数据访问层和服务层的实现。",
                url: "http://localhost:8080/static/image/java_1_2.jpg",
                link: "https://www.baidu.com",
                progress: "第一章"
            }, {
                courseId: "",
                courseName: "C++远征之多态篇",
                selectNumber: 32,
                teacher: "james_yuan",
                content: "简介：本课程将带领大家体会面向对象三大特性中的多态特性，讲述了虚函数、抽象类和接口类等概念，以及多态的实现原理，课程的最后引入RTTI及异常处理，使整个多态篇更加完整，更具实战指导性，本门课程是C++远征课程的高潮和经典，对于面向对象的语言的学习将大有裨益。",
                url: "http://localhost:8080/static/image/course_c++_2.jpg",
                link: "https://www.baidu.com",
                progress: "第二章"
            }, {
                courseId: "",
                courseName: "C++远征之继承篇",
                selectNumber: 54,
                teacher: "james_yuan",
                content: "简介：本课程将带领大家体会C++面向对象三大特性中的继承特性，讲述了基类、派生类的概念，公有继承、保护继承和私有继承、多重继承及多继承，虚析构函数及虚继承的作用，理解课程内容对于面向对象的学习将大有裨益，所有知识均通过编码实践的方式讲解到操作层面，力求即学即会。",
                url: "http://localhost:8080/static/image/course_c++_3.jpg",
                link: "https://www.baidu.com",
                progress: "第一章"
            }, {
                courseId: "",
                courseName: "C++远征之起航篇",
                selectNumber: 32,
                teacher: "james_yuan",
                content: "简介：本教程是C++的初级教程，是在C语言基础上的一个延伸，讲述了包括新增数据类型、命名空间等内容，最后通过一个通俗易懂的例子将所述知识点融会贯通，以达到知识灵活运用，最终得以升华的目的。",
                url: "http://localhost:8080/static/image/course_c++_4.jpg",
                link: "https://www.baidu.com",
                progress: "第二章"
            }],
            pageCourse: [],
            learningUrl: "https://search.bilibili.com/all?keyword=",
            historyData: [{
                courseName: "java实现权限管理（下）",
                courseId: "001",
                date: "一个小时前",
                url: "http://localhost:8080/static/image/java_1_1.jpg",
                progress: 50
            }, {
                courseName: "C++远征之模板篇",
                courseId: "002",
                date: "30分钟前",
                url: "http://localhost:8080/static/image/course_c++_1.jpg",
                progress: 30
            }, {
                courseName: "java实现权限管理（上）",
                courseId: "003",
                url: "http://localhost:8080/static/image/java_1_2.jpg",
                date: "2019年5月22日",
                progress: 70
            }],
            currentPage: 1,
            pageSize: 5,
            total: 100,
        }
    },
    mounted() {
        this.pageCourse = this.courses.slice(0, 5)
        this.total = this.courses.length
    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath)
        },
        handleClick(tab, event) {
            console.log(tab, event)
        },
        handleAvatarSuccess(res, file) {
            this.imageUrl = URL.createObjectURL(file.raw);
        },
        beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg';
            const isLt2M = file.size / 1024 / 1024 < 2;

            if (!isJPG) {
                this.$message.error('上传头像图片只能是 JPG 格式!');
            }
            if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!');
            }
            return isJPG && isLt2M;
        },
        handleClose(done) {
            this.$confirm('取消上传？')
                .then(_ => {
                    done();
                }).catch(_ => {
            });
        },
        checkValidate(form) {
            this.$refs[form].validate((valid) => {
                if (valid) {
                    this.dialogVisible = true;
                } else {
                    return false;
                }
            });
        },
        onSubmit(form) {
            this.dialogVisible = false
            console.log(form)
        },
        logout() {
            axios.get("loginout").then(function (response) {
                if (response.success === true) {
                    document.cookie = "sessionId" + "=" + "";
                }
            })
        },
        handleCurrentChange(val) {
            let pre = 0 + (val - 1) * 5
            let next = 5 + (val - 1) * 5
            this.pageCourse = this.courses.slice(pre, next)
        }
    }
})
axios.defaults.withCredentials = true

function validatePhone(str) {
    const reg = /^1[3|4|5|7|8][0-9]\d{8}$/
    console.log(reg.test(str))
    return reg.test(str)
}

var validPhone = (rule, value, callback) => {
    if (!value) {
        callback(new Error('请输入电话号码'))
    } else if (!validatePhone(value)) {
        callback(new Error('请输入正确的11位手机号码'))
    } else {
        callback()
    }
}
coursedata = [
    {
        courseID: '001',
        teacher: '王小虎',
        courseName: 'C++远征之模板篇',
        content: '简介：本教程是C++的初级教程，是在C语言基础上的一个延伸，讲述了包括新增数据类型、命名空间等内容，最后通过一个通俗易懂的例子将所述知识点融会贯通，以达到知识灵活运用，最终得以升华的目的。',
        updatedate: '2016-05-02',
        selectNum: 5
    },
    {
        courseID: '002',
        teacher: '王小虎',
        courseName: 'Java权限管理',
        content: '简介：Java权限管理系列课程介绍如何使用SpringMVC+Spring来实现基于RBAC的权限管理系统。本套系列课程包括两门课程，本课程是第一门课，主要介绍什么是基于角色的访问控制（RBAC），以及数据访问层和服务层的实现',
        updatedate: '2016-05-02',
        selectNum: 2
    },
    {
        courseID: '003',
        teacher: '王小虎',
        courseName: 'C++远征之继承篇',
        content: '简介：本课程将带领大家体会C++面向对象三大特性中的继承特性，讲述了基类、派生类的概念，公有继承、保护继承和私有继承、多重继承及多继承，虚析构函数及虚继承的作用，理解课程内容对于面向对象的学习将大有裨益，所有知识均通过编码实践的方式讲解到操作层面，力求即学即会。',
        updatedate: '2016-05-02',
        selectNum: 1
    },
]
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
                birth: new Date("1986-06-12"),
                phone: "1111111"
            },
            rules: {
                userName: [
                    {required: true, message: "请输入用户名", trigger: "blur"},
                    {min: 1, max: 10, message: "长度在2到10个字符之间", trigger: "blur"}
                ],
                gender: [{required: true, message: "请选择性别", trigger: "blur"}],
                birth: [{required: true, type: "date", message: "请选择生日", trigger: "blur"}],
                phone: [{required: true, validator: validPhone, trigger: "blur"}]
            },
            imageUrl: "",
            dialogVisible: false,
            tableData: coursedata,
            currentPage: 1,
            pageSize: 5,
            total: 5,


            dialogTableVisible: false,
            addCourseFormVisible: false,
            statisticCourseFormVisible: false,
            editCourseFormVisible: false,
            form: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            formLabelWidth: '120px',
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
        },

        editCourse(val) {
            const h = '课程 - ' + this.$createElement;
            this.$msgbox({
                title: coursedata[val].courseName,
                message:
                    h('div', null,
                        [
                            h('span', null, '内容可以是 '),
                            h('i', {style: 'color: teal'}, 'VNode')
                        ]
                    ),
                showCancelButton: true,
                confirmButtonText: '保存',
                cancelButtonText: '取消',
                beforeClose: (action, instance, done) => {
                    if (action === 'confirm') {
                        instance.confirmButtonLoading = true;
                        instance.confirmButtonText = '执行中...';
                        setTimeout(() => {
                            done();
                            setTimeout(() => {
                                instance.confirmButtonLoading = false;
                            }, 300);
                        }, 3000);
                    } else {
                        done();
                    }
                }
            }).then(action => {
                this.$message({
                    type: 'info',
                    message: 'action: ' + action
                });
            });
        },

        delCourse() {
            this.$confirm('此操作将删除该课程, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$message({
                    type: 'success',
                    message: '删除成功!'
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        }

    }


})
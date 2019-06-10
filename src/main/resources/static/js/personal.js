new Vue({
    el: "#personal-container",
    data: function () {
        return {
            headUrl: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
            activeIndex: "1",
            activeIndex2: "1",
            activeName: "1",
            man: "男",
            woman: "女",
            form: {
                userName: "小明",
                gender: "男",
                birth: new Date(),
                phone: "12345678911"
            },
            imageUrl: "",
            dialogVisible: false,
            courses: [{
                courseId: "",
                courseName: "java",
                selectNumber: 54,
                content: "阿斯顿发生啊手动阀手动阀手动阀",
                url: "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                link: "https://www.baidu.com",
                progress: "第一章"
            }, {
                courseId: "",
                courseName: "C++",
                selectNumber: 32,
                content: "爱上对方就按时灯笼裤飞机啊是快递放假咯",
                url: "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                link: "https://www.baidu.com",
                progress: "第二章"
            }, {
                courseId: "",
                courseName: "java",
                selectNumber: 54,
                content: "阿斯顿发生啊手动阀手动阀手动阀",
                url: "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                link: "https://www.baidu.com",
                progress: "第一章"
            }, {
                courseId: "",
                courseName: "C++",
                selectNumber: 32,
                content: "爱上对方就按时灯笼裤飞机啊是快递放假咯",
                url: "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                link: "https://www.baidu.com",
                progress: "第二章"
            }, {
                courseId: "",
                courseName: "java",
                selectNumber: 54,
                content: "阿斯顿发生啊手动阀手动阀手动阀",
                url: "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                link: "https://www.baidu.com",
                progress: "第一章"
            }, {
                courseId: "",
                courseName: "C++",
                selectNumber: 32,
                content: "爱上对方就按时灯笼裤飞机啊是快递放假咯",
                url: "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                link: "https://www.baidu.com",
                progress: "第二章"
            }],
            learningUrl: "https://search.bilibili.com/all?keyword=",
            downloadData: [{
                courseName: "java",
                courseId: "11",
                progress: 50
            }, {
                courseName: "C++",
                courseId: "ss",
                progress: 30
            }, {
                courseName: "java",
                courseId: "sa",
                progress: 70
            }, {
                courseName: "C++",
                courseId: "123",
                progress: 40
            }, {
                courseName: "java",
                courseId: "002",
                progress: 20
            }, {
                courseName: "C++",
                courseId: "001",
                progress: 30
            }]
        }
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
                }).catch(_ => {});
        },
        onSubmit(form) {
            this.dialogVisible = false
            console.log(form)
        }
    }
})
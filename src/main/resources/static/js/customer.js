new Vue({
    el: '.container',
    data: {
        url: "customers",
        number: 0,
        total: 0,
        titles: ['no', 'company', 'name', 'address', 'phone'],
        rows: [],
        row: {},
        title: ''
    },
    components: {},
    filters: {
        format: function (value) {
            return value.toFixed(2)
        }
    },
    mounted: function () {
        this.$nextTick(function () {
            this.list(1);
        });
    },
    methods: {
        show: function () {
            $('.modal').modal('show');
        },
        hide: function () {
            $('.modal').modal('hide');
        },
        change: function (index) {
            console.log('change page index');
            this.list(index);
        },
        list: function (index) {
            console.log("list:" + index);

            axios.get(this.url, {params: {page: index - 1}}).then(resp => {
                console.log(resp);
                const r = resp.data;
                if (r.code === 200) {
                    this.rows = r.data.content;
                    this.number = r.data.number;
                    this.total = r.data.totalPages;
                } else {
                    alert("加载数据出错");
                }
            });
        },
        insert: function () {
            this.row = {};
            this.title = '新增';
            this.show();
        },
        update: function (row) {
            this.row = row;
            this.title = '编辑';
            this.show();
        },
        remove: function (row) {
            console.log('delete', row.id);
        },
        save: function () {
            console.log("save");
            console.log(this.row);

            if (this.row.id) {
                axios.put(this.url, this.row).then(resp => {
                    this.hide();
                    this.list(1);
                });
            } else {
                axios.post(this.url, this.row).then(resp => {
                    this.hide();
                    this.list(1);
                });
            }
        }
    },
    computed: {
        titleClass: function () {
            return {"text-success": !this.row.id, "text-primary": !!this.row.id};
        }
    }
});




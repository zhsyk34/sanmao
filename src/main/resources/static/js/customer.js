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
            this.list(index);
        },
        list: function (index) {
            axios.get(this.url, {params: {page: index - 1}}).then(resp => {
                const r = resp.data;
                if (r.code === 200) {
                    const data = r.data;
                    if (data) {
                        this.rows = data.data;
                        this.number = data.number;
                        this.total = data.total;
                    }
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
        },
        save: function () {
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




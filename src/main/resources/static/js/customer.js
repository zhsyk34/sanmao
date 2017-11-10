new Vue({
    el: '.container',
    data: {
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
        change: function (index) {
            console.log('change page index');
            this.list(index);
        },
        list: function (index) {
            console.log(index);
            axios.get("customers").then(resp => {
                const r = resp.data;
                if (r.code === 200) {
                    this.rows = r.data.content;
                    console.log(r.data.content);
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

        }
    },
    computed: {
        titleClass: function () {
            return {"text-success": !this.row.id, "text-primary": !!this.row.id};
        }
    }
});




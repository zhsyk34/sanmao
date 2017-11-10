new Vue({
    el: '.container',
    data: {
        total: 5,
        titles: ['id', 'name', 'alias', 'size', 'unit', 'price'],
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
            axios.get("data/product.json").then(res => {
                this.rows = res.data.result;
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
    },
    computed: {
        titleClass: function () {
            return {"text-success": !this.row.id, "text-primary": !!this.row.id};
        }
    }
});




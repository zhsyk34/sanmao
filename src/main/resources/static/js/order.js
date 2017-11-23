const vue = new Vue({
    el: '.container',
    data: {
        url: "orders",
        title: '编辑',
        suppliers: [],
        supplier: {},
        products: [],
        product: {},
        customers: [],
        customer: {},
        details: [{product: {}, width: 100}, {product: {}, height: 200}],
        detail: {product: {}, width: 0, height: 0},
        data: this.detail
    },
    mounted: function () {
        this.$nextTick(function () {
            this.listSupplier();
            this.listProduct();
            this.listCustomer();
        });
    },
    methods: {
        show: function () {
            $('.modal').modal('show');
        },
        hide: function () {
            $('.modal').modal('hide');
        },
        listSupplier: function () {
            axios.get("suppliers").then(resp => {
                const r = resp.data;
                if (r.code === 200) {
                    const data = r.data;
                    r.data && (this.supplier = r.data.data);
                    if (data) {
                        this.suppliers = data.data;
                    }
                } else {
                    alert("加载数据出错");
                }
            });
        },
        listProduct: function () {
            axios.get("products").then(resp => {
                const r = resp.data;
                if (r.code === 200) {
                    const data = r.data;
                    if (data) {
                        this.products = data.data;
                    }
                } else {
                    alert("加载数据出错");
                }
            });
        },
        listCustomer: function () {
            axios.get("customers").then(resp => {
                const r = resp.data;
                if (r.code === 200) {
                    const data = r.data;
                    if (data) {
                        this.customers = data.data;
                    }
                } else {
                    alert("加载数据出错");
                }
            });
        },
        selectSupplier: function (supplier) {
            this.supplier = supplier;
        },
        selectProduct: function (product) {
            this.product = product;
        },
        selectCustomer: function (customer) {
            this.customer = customer;
        },
        addDetail: function () {
            this.detail = {};
            this.product = {};
            this.show();
        },
        delDetail: function (index) {
            this.details.splice(index, 1);
        },
        save: function () {
            console.log(this.detail);
            if (this.product.id) {
                this.detail.product = this.product;
                this.details.push(this.detail);
                this.hide();
            } else {
                alert('请完善数据');
            }
        }
    },
    computed: {
        showProduct: function () {
            const product = this.product;
            return product.id ? product.name + ' ( ' + product.price + '元/' + product.unit + ' )' : '';
        },
        showArea: function () {
            console.log(this.detail);
            const width = Number(this.detail.width);
            const height = Number(this.detail.height);
            console.log(width, height);
            if (width && height) {
                console.log('calc');
                return width * height;
            }
            return '';
        }
    }
});

// $('ul.dropdown-menu').on('click', 'li', function () {
//     const input = $(this).parents('.input-group').children('input');
//     input.val($(this).children('a').text());
// });
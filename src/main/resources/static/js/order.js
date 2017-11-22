const vue = new Vue({
    el: '.container',
    data: {
        url: "orders",
        products: [],
        detail: {product: {}},
        title: '新增',
        customers: [],
        customer: {},
        suppliers: [],
        supplier: {}
    },
    mounted: function () {
        this.$nextTick(function () {
            this.hide();
            this.show();
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
                    if (data) {
                        this.suppliers = data.data;
                        console.log('suppliers', this.suppliers);
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
            this.detail.product = product;
        },
        selectCustomer: function (customer) {
            this.customer = customer;
        },
        append: function () {
            var template = $('#detail').clone();
            $('tbody').append(template);
        },
        save: function () {

        }
    },
    computed: {
        showProduct: function () {
            const product = this.detail.product;
            return product.id ? product.name + ' ( ' + product.price + '元/' + product.unit + ' )' : '';
        },
        titleClass: function () {
            return {"text-success": !this.detail.product.id, "text-primary": !!this.detail.product.id};
        }
    }
});

// $('ul.dropdown-menu').on('click', 'li', function () {
//     const input = $(this).parents('.input-group').children('input');
//     input.val($(this).children('a').text());
// });
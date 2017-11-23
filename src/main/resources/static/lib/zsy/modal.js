Vue.component('modal', {
    props: {title: {type: String}, data: {type: Object}},
    template: `
    <div class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" :title="title">
                    <button type="button" class="close" data-dismiss="modal" aria-label="close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <slot name="modal-title"></slot>
                </div>
                <div class="modal-body" :data="data">
                    <slot></slot>
                </div>
                <slot name="modal-footer"></slot>
            </div>
        </div>
    </div>`
});


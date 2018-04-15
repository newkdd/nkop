<template>
  <div>
    <el-container>
      <el-header style="padding: 0px;display:flex;justify-content:space-between;align-items: center">
        <div style="display: inline">
          <el-input
            placeholder="通过员工名搜索账号,记得回车哦..."
            clearable
            @change="keywordsChange"
            style="width: 300px;margin: 0px;padding: 0px;"
            size="mini"
            :disabled="advanceSearchViewVisible"
            @keyup.enter.native="searchSysUsers"
            prefix-icon="el-icon-search"
            v-model="keywords">
          </el-input>
          <el-button type="primary" size="mini" style="margin-left: 5px" icon="el-icon-search" @click="searchSysUsers">搜索
          </el-button>
          <el-button slot="reference" type="primary" size="mini" style="margin-left: 5px"
                     @click="showAdvanceSearchView"><i
            class="fa fa-lg" v-bind:class="[advanceSearchViewVisible ? faangledoubleup:faangledoubledown]"
            style="margin-right: 5px"></i>高级搜索
          </el-button>
        </div>
        <div style="margin-left: 5px;margin-right: 20px;display: inline">
          <el-upload
            :show-file-list="false"
            accept="application/vnd.ms-excel"
            action="/v1/sys_users/import"
            :on-success="fileUploadSuccess"
            :on-error="fileUploadError" :disabled="fileUploadBtnText=='正在导入'"
            :before-upload="beforeFileUpload" style="display: inline">
            <el-button size="mini" type="success" :loading="fileUploadBtnText=='正在导入'"><i class="fa fa-lg fa-level-up"
                                                                                          style="margin-right: 5px"></i>{{fileUploadBtnText}}
            </el-button>
          </el-upload>
          <el-button type="success" size="mini" @click="exportSysUsers"><i class="fa fa-lg fa-level-down"
                                                                       style="margin-right: 5px"></i>导出数据
          </el-button>
          <el-button type="primary" size="mini" icon="el-icon-plus"
                     @click="showAddSysUserView">
            添加员工
          </el-button>
        </div>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div>
          <transition name="slide-fade">
            <div
              style="margin-bottom: 10px;border: 1px;border-radius: 5px;border-style: solid;padding: 5px 0px 5px 0px;box-sizing:border-box;border-color: #20a0ff"
              v-show="advanceSearchViewVisible">
              <el-row>
                <el-col :span="5">
                  账号:
                  <el-input prefix-icon="el-icon-edit" v-model="sysUser.username" size="mini" style="width: 150px"
                            placeholder="请输入员工账号"></el-input>
                </el-col>
                <el-col :span="5">
                  姓名:
                  <el-input prefix-icon="el-icon-edit" v-model="sysUser.realname" size="mini" style="width: 150px"
                            placeholder="请输入员工姓名"></el-input>
                </el-col>
                <el-col :span="5">
                  电话:
                  <el-input prefix-icon="el-icon-edit" v-model="sysUser.phone" size="mini" style="width: 150px"
                            placeholder="请输入员工电话"></el-input>
                </el-col>
                <el-col :span="5">
                  邮箱:
                  <el-input prefix-icon="el-icon-edit" v-model="sysUser.email" size="mini" style="width: 150px"
                            placeholder="请输入员工电话"></el-input>
                </el-col>
                <el-col :span="4">
                  <el-button size="mini" @click="cancelSearch">取消</el-button>
                  <el-button icon="el-icon-search" type="primary" size="mini" @click="searchSysUsers">搜索</el-button>
                </el-col>
              </el-row>
            </div>
          </transition>
          <el-table
            :data="SysUsers"
            v-loading="tableLoading"
            border
            stripe
            @selection-change="handleSelectionChange"
            size="mini"
            style="width: 100%">
            <el-table-column
              type="selection"
              align="left"
              width="30">
            </el-table-column>
            <el-table-column
              prop="realname"
              align="left"
              fixed
              label="姓名"
              width="90">
            </el-table-column>
            <el-table-column
              prop="username"
              width="85"
              align="left"
              label="账号">
            </el-table-column>
            <el-table-column
              prop="email"
              width="180"
              align="left"
              label="电子邮件">
            </el-table-column>
            <el-table-column
              prop="phone"
              width="100"
              label="电话号码">
            </el-table-column>
            <el-table-column
              prop="createdBy"
              width="100"
              label="创建人">
            </el-table-column>
            <el-table-column
              prop="createdDate"
              width="150"
              label="创建时间">
            </el-table-column>
            <el-table-column
              prop="modifiedDate"
              width="150"
              label="修改时间">
            </el-table-column>
            <el-table-column
              prop="lastLoginIP"
              width="100"
              label="最后登录IP">
            </el-table-column>
            <el-table-column
              prop="lastLoginTime"
              width="150"
              label="最后登录时间">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="120">
              <template slot-scope="scope">
                <el-button @click="showEditSysUserView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px"
                           size="mini">编辑
                </el-button>
                <el-button type="danger" style="padding: 3px 4px 3px 4px;margin: 2px" size="mini"
                           @click="deleteEmp(scope.row)">删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="display: flex;justify-content: space-between;margin: 2px">
            <el-button type="danger" size="mini" v-if="SysUsers.length>0" :disabled="multipleSelection.length==0"
                       @click="deleteManySysUsers">批量删除
            </el-button>
            <el-pagination
              background
              :page-size="10"
              :current-page="currentPage"
              @current-change="currentChange"
              layout="prev, pager, next"
              :total="totalCount">
            </el-pagination>
          </div>
        </div>
      </el-main>
    </el-container>
    <el-form :model="sysUser" :rules="rules" ref="addSysUserForm" style="margin: 0px;padding: 0px;">
      <div style="text-align: left">
        <el-dialog
          :title="dialogTitle"
          style="padding: 0px;"
          :close-on-click-modal="false"
          :visible.sync="dialogVisible"
          width="50%">
          <el-form-item label="账号:" prop="username" labelWidth="120px">
            <el-input prefix-icon="el-icon-edit" v-model="sysUser.username" size="mini"
                      placeholder="请输入员工账号"></el-input>
          </el-form-item>
          <el-form-item v-if="!edit" label="密码:" prop="password" labelWidth="120px">
            <el-input type="password" prefix-icon="el-icon-edit" v-model="sysUser.password" size="mini"
                      placeholder="请输入员工密码"></el-input>
          </el-form-item>
          <el-form-item label="姓名:" prop="realname" labelWidth="120px">
            <el-input prefix-icon="el-icon-edit" v-model="sysUser.realname" size="mini"
                      placeholder="请输入员工姓名"></el-input>
          </el-form-item>
          <el-form-item label="电话号码:" prop="phone" labelWidth="120px">
            <el-input prefix-icon="el-icon-phone" v-model="sysUser.phone" size="mini"
                      placeholder="电话号码..."></el-input>
          </el-form-item>
          <el-form-item label="电子邮箱:" prop="email" labelWidth="120px">
            <el-input prefix-icon="el-icon-message" v-model="sysUser.email" size="mini"
                      placeholder="电子邮箱地址..."></el-input>
          </el-form-item>
          <span slot="footer" class="dialog-footer">
            <el-button size="mini" @click="cancelEidt">取 消</el-button>
            <el-button size="mini" type="primary" @click="addSysUser('addSysUserForm')">确 定</el-button>
          </span>
        </el-dialog>
      </div>
    </el-form>
  </div>
</template>
<script>
  import ElRow from "element-ui/packages/row/src/row";

  export default {
    components: {ElRow},
    data() {
      return {
        SysUsers: [],
        keywords: '',
        fileUploadBtnText: '导入数据',
        faangledoubleup: 'fa-angle-double-up',
        faangledoubledown: 'fa-angle-double-down',
        dialogTitle: '',
        multipleSelection: [],
        depTextColor: '#c0c4cc',
        nations: [],
        politics: [],
        positions: [],
        joblevels: [],
        totalCount: -1,
        currentPage: 1,
        defaultProps: {
          label: 'name',
          isLeaf: 'leaf',
          children: 'children'
        },
        dialogVisible: false,
        edit:false,
        tableLoading: false,
        advanceSearchViewVisible: false,
        sysUser: {
          id: '',
          username: '',
          realname: '',
          password: '',
          phone: '',
          email: '',
          version: ''
        },
        rules: {
          username: [{required: true, message: '必填:账号', trigger: 'blur'}],
          realname: [{required: true, message: '必填:姓名', trigger: 'blur'}],
          password: [{required: true, message: '必填:密码', trigger: 'blur'}],
          phone: [{required: true, message: '必填:电话号码', trigger: 'blur'}],
          email: [{required: true, message: '必填:电子邮箱', trigger: 'blur'}, {
            type: 'email',
            message: '邮箱格式不正确',
            trigger: 'blur'
          }]
        }
      };
    },
    mounted: function () {
      this.initData();
      this.loadSysUsers();
    },
    methods: {
      fileUploadSuccess(response, file, fileList){
        if (response) {
          this.$message({type: response.status, message: response.msg});
        }
        this.loadSysUsers();
        this.fileUploadBtnText = '导入数据';
      },
      fileUploadError(err, file, fileList){
        this.$message({type: 'error', message: "导入失败!"});
        this.fileUploadBtnText = '导入数据';
      },
      beforeFileUpload(file){
        this.fileUploadBtnText = '正在导入';
      },
      exportSysUsers(){
        window.open("/v1/sys_users/export", "_parent");
      },
      cancelSearch(){
        this.advanceSearchViewVisible = false;
        this.emptySysUserData();
        this.loadSysUsers();
      },
      showAdvanceSearchView(){
        this.advanceSearchViewVisible = !this.advanceSearchViewVisible;
        this.keywords = '';
        if (!this.advanceSearchViewVisible) {
          this.emptySysUserData();
          this.beginDateScope = '';
          this.loadSysUsers();
        }
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      deleteManySysUsers(){
        this.$confirm('此操作将删除[' + this.multipleSelection.length + ']条数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          var ids = '';
          for (var i = 0; i < this.multipleSelection.length; i++) {
            ids += this.multipleSelection[i].id + ",";
          }
          this.doDelete(ids);
        }).catch(() => {
        });
      },
      deleteEmp(row){
        this.$confirm('此操作将永久删除[' + row.realname + '], 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.doDelete(row.id);
        }).catch(() => {
        });
      },
      doDelete(ids){
        this.tableLoading = true;
        var _this = this;
        this.deleteRequest("/v1/sys_users/" + ids).then(resp=> {
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.$message({type: data.status, message: '删除成功！'});
            _this.loadSysUsers();
          }
        })
      },
      keywordsChange(val){
        if (val == '') {
          this.loadSysUsers();
        }
      },
      searchSysUsers(){
        this.loadSysUsers();
      },
      currentChange(currentChange){
        this.currentPage = currentChange;
        this.loadSysUsers();
      },
      loadSysUsers(){
        var _this = this;
        this.tableLoading = true;
        this.getRequest("/v1/sys_users/user_page?page=" + this.currentPage + "&per_page=10&keywords=" + this.keywords+"&username=" + this.sysUser.username+"&realname=" + this.sysUser.realname+"&phone=" + this.sysUser.phone+"&email=" + this.sysUser.email).then(resp=> {
          this.tableLoading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.SysUsers = data.data;
            _this.totalCount = data.total;
          }
        })
      },
      addSysUser(formName){
        var _this = this;
        _this.$refs[formName].validate((valid) => {
          if (valid) {
            if (_this.sysUser.id) {
              //更新
              _this.tableLoading = true;
              _this.putRequest("/v1/sys_users", _this.sysUser).then(resp=> {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.$message({type: data.status, message:'更新成功！'});
                  _this.dialogVisible = false;
                  _this.emptySysUserData();
                  _this.loadSysUsers();
                }
              })
            } else {
              //添加
              _this.tableLoading = true;
              _this.postRequest("/v1/sys_users", _this.sysUser).then(resp=> {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.$message({type: data.status, message: '新建成功！'});
                  _this.dialogVisible = false;
                  _this.emptySysUserData();
                  _this.loadSysUsers();
                }
              })
            }
          } else {
            return false;
          }
        });
      },
      cancelEidt(){
        this.dialogVisible = false;
        this.emptySysUserData();
      },
      initData(){
        var _this = this;

      },
      showEditSysUserView(row){
        console.log(row)
        this.dialogTitle = "编辑员工";
        this.sysUser.id = row.id ;
        this.sysUser.username = row.username ;
        this.sysUser.realname = row.realname ;
        this.sysUser.phone = row.phone ;
        this.sysUser.email = row.email ;
        this.sysUser.version = row.version;
        this.edit = true;
        this.dialogVisible = true;
      },
      showAddSysUserView(){
        this.dialogTitle = "添加员工";
        this.edit = false;
        this.dialogVisible = true;
      },
      emptySysUserData(){
        this.sysUser = {
          username: '',
          realname: '',
          password: '',
          version: '',
          phone: '',
          email: ''
        }
      }
    }
  };
</script>
<style>
  .el-dialog__body {
    padding-top: 0px;
    padding-bottom: 0px;
  }

  .slide-fade-enter-active {
    transition: all .8s ease;
  }

  .slide-fade-leave-active {
    transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
  }

  .slide-fade-enter, .slide-fade-leave-to {
    transform: translateX(10px);
    opacity: 0;
  }
</style>

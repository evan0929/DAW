package com.popper.daw.bean;

import java.util.List;

public class OrderListBean {

    private Object searchValue;
    private String createBy;
    private String createTime;
    private String updateBy;
    private Object updateTime;
    private String remark;
    private ParamsBean params;
    private Integer orderId;
    private String orderName;
    private String applyDate;
    private String projectId;
    private String projectName;
    private String projectProvince;
    private String emergency;
    private String costCenterCode;
    private String costCenterName;
    private String salesChannelsId;
    private String salesChannelsName;
    private String delFlag;
    private String currentBy;
    private String status;
    private Object transfer;
    private Object disId;
    private Object signtx;
    private Object type;
    private Object editorNo;
    private Object submitState;
    private Object nowNode;
    private List<DawColorDetailBean> dawColorDetail;

    public Object getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(Object searchValue) {
        this.searchValue = searchValue;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectProvince() {
        return projectProvince;
    }

    public void setProjectProvince(String projectProvince) {
        this.projectProvince = projectProvince;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getCostCenterName() {
        return costCenterName;
    }

    public void setCostCenterName(String costCenterName) {
        this.costCenterName = costCenterName;
    }

    public String getSalesChannelsId() {
        return salesChannelsId;
    }

    public void setSalesChannelsId(String salesChannelsId) {
        this.salesChannelsId = salesChannelsId;
    }

    public String getSalesChannelsName() {
        return salesChannelsName;
    }

    public void setSalesChannelsName(String salesChannelsName) {
        this.salesChannelsName = salesChannelsName;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCurrentBy() {
        return currentBy;
    }

    public void setCurrentBy(String currentBy) {
        this.currentBy = currentBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getTransfer() {
        return transfer;
    }

    public void setTransfer(Object transfer) {
        this.transfer = transfer;
    }

    public Object getDisId() {
        return disId;
    }

    public void setDisId(Object disId) {
        this.disId = disId;
    }

    public Object getSigntx() {
        return signtx;
    }

    public void setSigntx(Object signtx) {
        this.signtx = signtx;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getEditorNo() {
        return editorNo;
    }

    public void setEditorNo(Object editorNo) {
        this.editorNo = editorNo;
    }

    public Object getSubmitState() {
        return submitState;
    }

    public void setSubmitState(Object submitState) {
        this.submitState = submitState;
    }

    public Object getNowNode() {
        return nowNode;
    }

    public void setNowNode(Object nowNode) {
        this.nowNode = nowNode;
    }

    public List<DawColorDetailBean> getDawColorDetail() {
        return dawColorDetail;
    }

    public void setDawColorDetail(List<DawColorDetailBean> dawColorDetail) {
        this.dawColorDetail = dawColorDetail;
    }

    public static class ParamsBean {
    }

    public static class DawColorDetailBean {
        private Object searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private Integer detailId;
        private Integer orderId;
        private String bigTypeId;
        private String bigTypeName;
        private String methodId;
        private String methodName;
        private String constructionId;
        private String constructionName;
        private String palletSize;
        private String style;
        private String palletRemark;
        private Integer ybPrice;
        private Integer ybNumber;
        private Integer yqPrice;
        private Integer yqNumber;
        private Integer amount;
        private String sourceColor;
        private String colorRemark;
        private String expressNo;
        private Object exprId;
        private Object colorNum;
        private Object colorVal;
        private Object colorDescription;
        private Object formulaImg;
        private Object contrastImg;
        private String delFlag;
        private String directorFlag;
        private String engineerFlag;
        private String engineerStatus;
        private Object factoryId;
        private Object factoryName;
        private Object director;
        private Object directorName;
        private Object engineer;
        private Object engineerName;
        private String shStatus;
        private Object dawColorFactory;
        private Object dawColorExpsheetd;
        private List<DawColorMaterialListBean> dawColorMaterialList;
        private Object dawColorExpress;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public Integer getDetailId() {
            return detailId;
        }

        public void setDetailId(Integer detailId) {
            this.detailId = detailId;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        public String getBigTypeId() {
            return bigTypeId;
        }

        public void setBigTypeId(String bigTypeId) {
            this.bigTypeId = bigTypeId;
        }

        public String getBigTypeName() {
            return bigTypeName;
        }

        public void setBigTypeName(String bigTypeName) {
            this.bigTypeName = bigTypeName;
        }

        public String getMethodId() {
            return methodId;
        }

        public void setMethodId(String methodId) {
            this.methodId = methodId;
        }

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public String getConstructionId() {
            return constructionId;
        }

        public void setConstructionId(String constructionId) {
            this.constructionId = constructionId;
        }

        public String getConstructionName() {
            return constructionName;
        }

        public void setConstructionName(String constructionName) {
            this.constructionName = constructionName;
        }

        public String getPalletSize() {
            return palletSize;
        }

        public void setPalletSize(String palletSize) {
            this.palletSize = palletSize;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getPalletRemark() {
            return palletRemark;
        }

        public void setPalletRemark(String palletRemark) {
            this.palletRemark = palletRemark;
        }

        public Integer getYbPrice() {
            return ybPrice;
        }

        public void setYbPrice(Integer ybPrice) {
            this.ybPrice = ybPrice;
        }

        public Integer getYbNumber() {
            return ybNumber;
        }

        public void setYbNumber(Integer ybNumber) {
            this.ybNumber = ybNumber;
        }

        public Integer getYqPrice() {
            return yqPrice;
        }

        public void setYqPrice(Integer yqPrice) {
            this.yqPrice = yqPrice;
        }

        public Integer getYqNumber() {
            return yqNumber;
        }

        public void setYqNumber(Integer yqNumber) {
            this.yqNumber = yqNumber;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public String getSourceColor() {
            return sourceColor;
        }

        public void setSourceColor(String sourceColor) {
            this.sourceColor = sourceColor;
        }

        public String getColorRemark() {
            return colorRemark;
        }

        public void setColorRemark(String colorRemark) {
            this.colorRemark = colorRemark;
        }

        public String getExpressNo() {
            return expressNo;
        }

        public void setExpressNo(String expressNo) {
            this.expressNo = expressNo;
        }

        public Object getExprId() {
            return exprId;
        }

        public void setExprId(Object exprId) {
            this.exprId = exprId;
        }

        public Object getColorNum() {
            return colorNum;
        }

        public void setColorNum(Object colorNum) {
            this.colorNum = colorNum;
        }

        public Object getColorVal() {
            return colorVal;
        }

        public void setColorVal(Object colorVal) {
            this.colorVal = colorVal;
        }

        public Object getColorDescription() {
            return colorDescription;
        }

        public void setColorDescription(Object colorDescription) {
            this.colorDescription = colorDescription;
        }

        public Object getFormulaImg() {
            return formulaImg;
        }

        public void setFormulaImg(Object formulaImg) {
            this.formulaImg = formulaImg;
        }

        public Object getContrastImg() {
            return contrastImg;
        }

        public void setContrastImg(Object contrastImg) {
            this.contrastImg = contrastImg;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getDirectorFlag() {
            return directorFlag;
        }

        public void setDirectorFlag(String directorFlag) {
            this.directorFlag = directorFlag;
        }

        public String getEngineerFlag() {
            return engineerFlag;
        }

        public void setEngineerFlag(String engineerFlag) {
            this.engineerFlag = engineerFlag;
        }

        public String getEngineerStatus() {
            return engineerStatus;
        }

        public void setEngineerStatus(String engineerStatus) {
            this.engineerStatus = engineerStatus;
        }

        public Object getFactoryId() {
            return factoryId;
        }

        public void setFactoryId(Object factoryId) {
            this.factoryId = factoryId;
        }

        public Object getFactoryName() {
            return factoryName;
        }

        public void setFactoryName(Object factoryName) {
            this.factoryName = factoryName;
        }

        public Object getDirector() {
            return director;
        }

        public void setDirector(Object director) {
            this.director = director;
        }

        public Object getDirectorName() {
            return directorName;
        }

        public void setDirectorName(Object directorName) {
            this.directorName = directorName;
        }

        public Object getEngineer() {
            return engineer;
        }

        public void setEngineer(Object engineer) {
            this.engineer = engineer;
        }

        public Object getEngineerName() {
            return engineerName;
        }

        public void setEngineerName(Object engineerName) {
            this.engineerName = engineerName;
        }

        public String getShStatus() {
            return shStatus;
        }

        public void setShStatus(String shStatus) {
            this.shStatus = shStatus;
        }

        public Object getDawColorFactory() {
            return dawColorFactory;
        }

        public void setDawColorFactory(Object dawColorFactory) {
            this.dawColorFactory = dawColorFactory;
        }

        public Object getDawColorExpsheetd() {
            return dawColorExpsheetd;
        }

        public void setDawColorExpsheetd(Object dawColorExpsheetd) {
            this.dawColorExpsheetd = dawColorExpsheetd;
        }

        public List<DawColorMaterialListBean> getDawColorMaterialList() {
            return dawColorMaterialList;
        }

        public void setDawColorMaterialList(List<DawColorMaterialListBean> dawColorMaterialList) {
            this.dawColorMaterialList = dawColorMaterialList;
        }

        public Object getDawColorExpress() {
            return dawColorExpress;
        }

        public void setDawColorExpress(Object dawColorExpress) {
            this.dawColorExpress = dawColorExpress;
        }

        public static class ParamsBean {
        }

        public static class DawColorMaterialListBean {
            private Object searchValue;
            private String createBy;
            private String createTime;
            private String updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBean params;
            private Integer materialId;
            private String materialNo;
            private Object materialGroup;
            private Object materialName;
            private Integer detailId;
            private Integer orderId;
            private String colorNum;
            private String colorVal;
            private String finalColorNum;
            private String status;
            private Object sendSh;

            public Object getSearchValue() {
                return searchValue;
            }

            public void setSearchValue(Object searchValue) {
                this.searchValue = searchValue;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public Integer getMaterialId() {
                return materialId;
            }

            public void setMaterialId(Integer materialId) {
                this.materialId = materialId;
            }

            public String getMaterialNo() {
                return materialNo;
            }

            public void setMaterialNo(String materialNo) {
                this.materialNo = materialNo;
            }

            public Object getMaterialGroup() {
                return materialGroup;
            }

            public void setMaterialGroup(Object materialGroup) {
                this.materialGroup = materialGroup;
            }

            public Object getMaterialName() {
                return materialName;
            }

            public void setMaterialName(Object materialName) {
                this.materialName = materialName;
            }

            public Integer getDetailId() {
                return detailId;
            }

            public void setDetailId(Integer detailId) {
                this.detailId = detailId;
            }

            public Integer getOrderId() {
                return orderId;
            }

            public void setOrderId(Integer orderId) {
                this.orderId = orderId;
            }

            public String getColorNum() {
                return colorNum;
            }

            public void setColorNum(String colorNum) {
                this.colorNum = colorNum;
            }

            public String getColorVal() {
                return colorVal;
            }

            public void setColorVal(String colorVal) {
                this.colorVal = colorVal;
            }

            public String getFinalColorNum() {
                return finalColorNum;
            }

            public void setFinalColorNum(String finalColorNum) {
                this.finalColorNum = finalColorNum;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Object getSendSh() {
                return sendSh;
            }

            public void setSendSh(Object sendSh) {
                this.sendSh = sendSh;
            }

            public static class ParamsBean {
            }
        }
    }

    @Override
    public String toString() {
        return "OrderListBean{" +
                "searchValue=" + searchValue +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", params=" + params +
                ", orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", applyDate='" + applyDate + '\'' +
                ", projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectProvince=" + projectProvince +
                ", emergency='" + emergency + '\'' +
                ", costCenterCode='" + costCenterCode + '\'' +
                ", costCenterName='" + costCenterName + '\'' +
                ", salesChannelsId='" + salesChannelsId + '\'' +
                ", salesChannelsName='" + salesChannelsName + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", currentBy='" + currentBy + '\'' +
                ", status='" + status + '\'' +
                ", transfer=" + transfer +
                ", disId=" + disId +
                ", signtx=" + signtx +
                ", type=" + type +
                ", editorNo=" + editorNo +
                ", submitState=" + submitState +
                ", nowNode=" + nowNode +
                ", dawColorDetail=" + dawColorDetail +
                '}';
    }
}

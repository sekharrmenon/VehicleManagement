<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="tag-wrapper" id="tag-wrapper">

	<div class="box-body">
			<div class="col-md-12 left-pane" id="portlet-body-left-pane" style="padding:0px !important">
				<div class="map-content"
					style="border: 1px solid #dbdbdb; margin-top: 12px;">

					<div class="map-body" style="background: #e5e5e5;">
						<fieldset class="gllpLatlonPicker">
							<div class="form-group col-md-12">
								<div class="input-group" ></div>

								<div>

									<div id="vehicleGeoMap" style="height: 280px; width: 100%">
										Maps loading...</div>
								</div>

								<div class="col-md-12 geo-tag-inputs"	style="margin: 4px 0 0 0;">
									<div class="col-md-4 col-xs-4">
										<label>Latitude: </label>
										<input type="text" class="gllpLatitude"	id="gllpLatitude" onkeypress="return FnAllowNumbersOnly(event)" value="" />
									</div>
									<div class="col-md-4 col-xs-4">
										<label>Longitude:</label>
										<input type="text"	class="gllpLongitude" onkeypress="return FnAllowNumbersOnly(event)" id="gllpLongitude" value="" /> 
									</div>
									<div class="col-md-4 col-xs-4">
									<label>Zoom:</label><br/>
									<input	type="number" class="gllpZoom" id="gllpZoom"	 style="" onkeypress="return FnAllowNumbersOnly(event)"  min="0"  max="18" value="3" /> 
									<span	class="glyphicon glyphicon-search gllpUpdateButton hidden"	style="cursor: pointer;"></span>
										</div>
										
								</div>
							</div>
						</fieldset>
					</div>
				</div>
			</div>
	</div>
</div>



<script src="resources/plugins/jquery.form.js"></script>
<script src="resources/js/getTagTemplate.js"></script>
<script>
	$('aside.control-sidebar').show().addClass('control-sidebar-open'); 
	$('body').addClass('sidebar-collapse');
</script>

